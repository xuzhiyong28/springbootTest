package com.springboottest.domain;/**
 * Created by Administrator on 2017/7/26.
 */

import java.io.Serializable;

/**
 * @author xuzhiyong
 * @createDate 2017-07-26-9:25
 * webscoket配置类 -- 浏览器发送消息的接收类
 */
public class RequestMessage implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
