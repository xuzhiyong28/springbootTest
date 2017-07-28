package com.springboottest.config;/**
 * Created by Administrator on 2017/7/26.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author xuzhiyong
 * @createDate 2017-07-26-9:26
 * webscoket配置类
 */
@Configuration
@EnableWebSocketMessageBroker
/**
 1.@EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思。
 2.registerStompEndpoints方法表示注册STOMP协议的节点，并指定映射的URL。
 3.stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();这一行代码用来注册STOMP协议节点，同时指定使用SockJS协议。
 4.configureMessageBroker方法用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
 *
 * */
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
