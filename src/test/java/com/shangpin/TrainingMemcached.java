package com.shangpin;

import net.spy.memcached.MemcachedClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shangpin.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TrainingMemcached {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemcachedClient memcachedClient;
	@Autowired
	private UserService userService;
	
//	@Test
//	public void test () {
//		Object o = memcachedClient.get("123456");
//		System.out.println((o == null));
//	}
	
	@Test
	public void testMemcached () {
		User user = new User();
		user.setId("123456");
		user.setName("Hello");
		log.info("测试添加数据");
		userService.saveUser(user);
		log.info("第一次测试获取数据");
		userService.getUser("123456");
		
		log.info("第二次测试获取数据");
		userService.getUser("123456");
	}

}
