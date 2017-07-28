package com.springboottest.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboottest.dao.ShiroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/15.
 */
@Repository
public class ShiroDaoImpl implements ShiroDao {
    @Autowired
    @Qualifier("mybatisJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public JSONArray getPermissionByRoleId(String roleId) {
        List<Map<String,Object>> permissionList = jdbcTemplate.queryForList("select sp.*  from sys_role_permission srp join sys_permission sp on sp.id = srp.permission_id where srp.role_id = ?",new String[]{roleId});
        if(permissionList != null && permissionList.size() > 0){
            JSONArray permissionArray = JSONArray.parseArray(JSON.toJSONString(permissionList));
            return permissionArray;
        }
        return null;
    }

    @Override
    public JSONArray getRoleAll() {
        List<Map<String ,Object>> roleList = jdbcTemplate.queryForList("SELECT * FROM sys_role order by id");
        if(roleList != null && roleList.size() > 0){
            JSONArray roleArray = JSONArray.parseArray(JSON.toJSONString(roleList));
            return roleArray;
        }
        return null;
    }

}
