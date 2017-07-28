package com.springboottest.dao;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface ShiroDao {
    public JSONArray getPermissionByRoleId(String roleId);
    public JSONArray getRoleAll();
}
