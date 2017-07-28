package com.springboottest.dao;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface UserInfoDao {
    public JSONObject getUserInfo(String username);
}
