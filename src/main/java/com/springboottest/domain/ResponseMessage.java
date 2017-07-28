package com.springboottest.domain;/**
 * Created by Administrator on 2017/7/26.
 */

/**
 * @author xuzhiyong
 * @createDate 2017-07-26-9:28
 * webscoket配置类 -- 消息相应类
 */
public class ResponseMessage {
    private String responseMessage;

    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
