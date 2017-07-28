package com.springboottest.tools;

import com.springboottest.domain.UserInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Administrator on 2017/7/16.
 */
public class PasswordHelper {
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(UserInfo userInfo) {
        //md5(md5(密码+username+salt2))
        String salt = ByteSource.Util.bytes(userInfo.getUsername()).toString();
        String newPassword = new SimpleHash(algorithmName, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getUsername()) , hashIterations).toHex();
        userInfo.setPassword(newPassword);
        userInfo.setSalt(salt);
    }

}
