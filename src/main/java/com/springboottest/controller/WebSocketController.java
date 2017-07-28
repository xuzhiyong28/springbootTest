package com.springboottest.controller;/**
 * Created by Administrator on 2017/7/26.
 */

import com.springboottest.domain.RequestMessage;
import com.springboottest.domain.ResponseMessage;
import com.springboottest.util.SpringUtil;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuzhiyong
 * @createDate 2017-07-26-9:30
 */
@Controller
@RequestMapping("/webscoket")
public class WebSocketController {

    ////接收客户端的消息，并发送给所有订阅了"/topic/getResponse"的用户
    @MessageMapping("/webscoket/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }

    @RequestMapping("/index")
    public String index() {
        return "webscoket";
    }

    @MessageMapping("/webscoket/welcome2")
    public void say2(RequestMessage message) {
        /**
         * 也可以直接使用下面的代码直接从服务器对订阅了"/topic/getResponse"的客户端发送请求，前提是客户端必须先连接上
         * 可以配合上一个定时器 时时推送消息
         * */
        SimpMessagingTemplate simpMessagingTemplate = (SimpMessagingTemplate) SpringUtil.getBean(SimpMessagingTemplate.class);
        simpMessagingTemplate.convertAndSend("/topic/getResponse", new ResponseMessage("welcome!"));
    }
}
