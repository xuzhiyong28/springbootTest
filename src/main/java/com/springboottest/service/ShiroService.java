package com.springboottest.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboottest.domain.UserInfo;
import com.springboottest.tools.Page;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface ShiroService {
    public JSONObject getUserInfo(String username);
    public JSONArray getRoleAll();
    public int addUserInfo(UserInfo userInfo , String roleId);
    public JSONArray gerPermissionAll();
    public int deletePermissionById(String id);
    public Page queryUserList(Map<String,String> param);
    public void updatePermission(); //重新加载权限

}
