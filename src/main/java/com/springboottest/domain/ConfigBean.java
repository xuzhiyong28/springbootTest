package com.springboottest.domain;

/**
 * Created by Administrator on 2017/7/8.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.math.BigInteger;

@Configuration
@ConfigurationProperties(prefix = "com.xzy")
@PropertySource("classpath:custom.properties")
public class ConfigBean {
    private String name;
    private String message;
    private String secret;
    private Integer number;
    private BigInteger bignumber;
    private String uuid;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigInteger getBignumber() {
        return bignumber;
    }

    public void setBignumber(BigInteger bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
