package com.springboottest.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboottest.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/15.
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    @Qualifier("mybatisJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public JSONObject getUserInfo(String username) {
        JSONObject userInfo = new JSONObject();
        List<Map<String,Object>> userInfoList =  jdbcTemplate.queryForList("SELECT ui.*, sur.role_id as roleid FROM user_info ui JOIN sys_user_role sur ON ui.uid = sur.uid WHERE ui.username = ?   " , new String[]{username});
        if(userInfoList.size() > 0){
            Map<String,Object> userInfoBean = userInfoList.get(0);
            userInfo = JSONObject.parseObject(JSON.toJSONString(userInfoBean));
            return userInfo;
        }
        return null;
    }
}
