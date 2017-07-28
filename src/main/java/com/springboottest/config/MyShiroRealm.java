package com.springboottest.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboottest.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/7/15.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;
    /*是否有权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        JSONObject userInfo = (JSONObject)  SecurityUtils.getSubject().getPrincipal();
        if(userInfo.getJSONArray("permissionArray").size() > 0){
            JSONArray permissionArray = userInfo.getJSONArray("permissionArray");
            for(int i = 0 ; i < permissionArray.size() ; i++){
                authorizationInfo.addStringPermission(permissionArray.getJSONObject(i).getString("url"));
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //前端用户输入的用户名
        String username = (String)authenticationToken.getPrincipal();
        JSONObject userInfo = shiroService.getUserInfo(username);
        if(userInfo == null) return null;
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userInfo,
                userInfo.getString("password"),
                ByteSource.Util.bytes(username),
                getName());

        //当认证都通过后，将用户信息放到session里面
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", userInfo);
        return simpleAuthenticationInfo;
    }
}
