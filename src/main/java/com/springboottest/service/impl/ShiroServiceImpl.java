package com.springboottest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboottest.dao.ShiroDao;
import com.springboottest.dao.UserInfoDao;
import com.springboottest.domain.UserInfo;
import com.springboottest.service.ShiroService;
import com.springboottest.tools.Page;
import com.springboottest.tools.PasswordHelper;
import com.springboottest.tools.StringUtil;
import com.springboottest.util.SpringUtil;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/15.
 */
@Service
@Transactional(value = "mybatisTransactionManager")
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private ShiroDao shiroDao;

    @Autowired
    @Qualifier("mybatisJdbcTemplate")
    private JdbcTemplate jdbcTemplate;



    @Override
    public JSONObject getUserInfo(String username) {
        JSONObject userInfo = userInfoDao.getUserInfo(username);
        if (userInfo != null) {
            JSONArray permissionArray = shiroDao.getPermissionByRoleId(userInfo.getString("roleid"));
            userInfo.put("permissionArray", permissionArray != null ? permissionArray : new JSONArray());
        }
        return userInfo;
    }

    /**
     * 获取所有角色
     *
     * @return
     */
    @Override
    public JSONArray getRoleAll() {
        return shiroDao.getRoleAll();
    }

    @Override
    @Transactional(value = "mybatisTransactionManager")
    public int addUserInfo(UserInfo userInfo, String roleId) {
        PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encryptPassword(userInfo);
        String uuid = UUID.randomUUID().toString();
        int count = jdbcTemplate.update("INSERT INTO user_info (username,name,password,salt,state) values (?,?,?,?,?)",
                new String[]{userInfo.getUsername(), userInfo.getName(), userInfo.getPassword(), userInfo.getSalt(), "1"});
        if (count > 0) {
            int newId = jdbcTemplate.queryForObject("SELECT max(uid) from user_info ", Integer.class);
            count = jdbcTemplate.update("INSERT INTO sys_user_role (role_id,uid) VALUES (?,?)", new String[]{roleId, String.valueOf(newId)});
        }
        return count;
    }

    /**
     * Cacheable 用来设置缓存，在对其删除和更新的时候需要重新刷新缓存
     *
     * @return
     */
    @Override
    @Cacheable(value = "permissionCache", keyGenerator = "wiselyKeyGenerator")
    public JSONArray gerPermissionAll() {
        List<Map<String, Object>> permissList = jdbcTemplate.queryForList("SELECT * FROM sys_permission order by id");
        if (permissList != null && permissList.size() > 0) {
            JSONArray permissArray = JSONArray.parseArray(JSON.toJSONString(permissList));
            return permissArray;
        }
        return null;
    }

    /***
     * 这里需要删除上面配置的缓存
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = {"permissionCache"}, allEntries = true)
    public int deletePermissionById(String id) {
        return jdbcTemplate.update("DELETE from sys_permission where id = ?", new String[]{id});
    }


    @Override
    public Page queryUserList(Map<String, String> param) {
        StringBuffer sql = new StringBuffer();
        sql.append("select ui.*, (select sur.role_id  from sys_user_role sur where sur.uid = ui.uid ) roleid from user_info ui  where 1=1 ");
        if (!StringUtil.isNull((String) param.get("username"))) {
            sql.append(" and ui.username like '%").append((String) param.get("username")).append("%'");
        }
        if (!StringUtil.isNull((String) param.get("title"))) {
            sql.append(" and ui.name like '%").append((String) param.get("name")).append("%'");
        }
        Page page = new Page(sql.toString(), Integer.parseInt(param.get("page").toString()), Integer.parseInt(param.get("rows").toString()), jdbcTemplate);
        return page;
    }

    /***
     * 重新加载权限
     */
    @Override
    public void updatePermission() {
        ShiroFilterFactoryBean shirFilter = (ShiroFilterFactoryBean) SpringUtil.getBean(ShiroFilterFactoryBean.class);
        synchronized (shirFilter) {
            AbstractShiroFilter shiroFilter = null;
            try {
                shiroFilter = (AbstractShiroFilter) shirFilter.getObject();
            } catch (Exception e) {
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }
            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
                    .getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver
                    .getFilterChainManager();

            //清空老的权限
            manager.getFilterChains().clear();
            shirFilter.getFilterChainDefinitionMap().clear();
            Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
            //配置退出
            filterChainDefinitionMap.put("/logout", "logout");
            //配置不会被拦截的连接
            filterChainDefinitionMap.put("/css/**", "anon");
            filterChainDefinitionMap.put("/js/**", "anon");
            filterChainDefinitionMap.put("/images/**", "anon");
            filterChainDefinitionMap.put("/fonts/**", "anon");
            filterChainDefinitionMap.put("/assets/**", "anon");
            filterChainDefinitionMap.put("/docs/**", "anon");
            filterChainDefinitionMap.put("/learn/register/**", "anon"); //注册页面
            JSONArray permissionArray = this.gerPermissionAll();
            if (permissionArray != null) {
                for (int i = 0; i < permissionArray.size(); i++) {
                    JSONObject obj = permissionArray.getJSONObject(i);
                    filterChainDefinitionMap.put(obj.getString("url"), "perms[" + obj.getString("url") + "]");
                }
            }
            shirFilter
                    .setFilterChainDefinitionMap(filterChainDefinitionMap);

            // 重新构建生成
            Map<String, String> chains = shirFilter
                    .getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim()
                        .replace(" ", "");
                manager.createChain(url, chainDefinition);
            }

        }
    }


}
