package com.springboottest;

import com.springboottest.dao.ShiroDao;
import com.springboottest.dao.UserInfoDao;
import com.springboottest.domain.LearnResouce;
import com.springboottest.service.LearnMybatisService;
import com.springboottest.service.ShiroService;
import com.springboottest.util.SpringUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboottestApplicationTests {

	@Autowired
	@Qualifier("oneJdbcTemplate")
	private JdbcTemplate oneJdbcTemplate; //使用数据源1

	@Autowired
	private LearnMybatisService learnMybatisService;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private ShiroDao shiroDao;

	@Autowired
	private ShiroService shiroService;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;




	@Test
	public void contextLoads() {
		SimpMessagingTemplate simpMessagingTemplate = (SimpMessagingTemplate) SpringUtil.getBean(SimpMessagingTemplate.class);
		simpMessagingTemplate.convertAndSend("","");
	}

}
