package com.springboottest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/7/13.
 * 多数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "mybatisDataSource")
    @Qualifier("mybatisDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mybatis")
    @Primary
    public DataSource mybatisDataSource() {
        //使用阿里的连接池
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.mybatis.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.mybatis.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.mybatis.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.mybatis.driver-class-name"));
        dataSource.setInitialSize(2);//初始化时建立物理连接的个数
        dataSource.setMaxActive(20);//最大连接池数量
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }



    @Bean(name = "oneDataSource")
    @Qualifier("oneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.onesql")
    public DataSource oneDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.onesql.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.onesql.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.onesql.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.onesql.driver-class-name"));
        dataSource.setInitialSize(2);//初始化时建立物理连接的个数
        dataSource.setMaxActive(20);//最大连接池数量
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }

    @Bean(name = "twoDataSource")
    @Qualifier("twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.twosql")
    public DataSource twoDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.twosql.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.twosql.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.twosql.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.twosql.driver-class-name"));
        dataSource.setInitialSize(2);//初始化时建立物理连接的个数
        dataSource.setMaxActive(20);//最大连接池数量
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }


    //@Primary 必须要有一个， 因为有多个相同类型的JdbcTemplate同时注册进来，必须指定默认的一个
    @Bean(name = "mybatisJdbcTemplate")
    @Primary
    public JdbcTemplate mybatisJdbcTemplate(
            @Qualifier("mybatisDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "oneJdbcTemplate")
    public JdbcTemplate oneJdbcTemplate(
            @Qualifier("oneDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "twoJdbcTemplate")
    public JdbcTemplate twoJdbcTemplate(
            @Qualifier("twoDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
