package com.foodvotebox.serviceTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbUser;

public class UserServiceTest {
	@Test
	public void testUserService() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		FvbUserMapper fvbUserMapper = applicationContext.getBean(FvbUserMapper.class);
		FvbUser user = fvbUserMapper.queryById(12);
		FvbUser user1 = fvbUserMapper.queryByUserName("zhangsan1");
		System.out.println(user1);
	}

	@Test
	public void testAddUser() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		FvbUserMapper fvbUserMapper = applicationContext.getBean(FvbUserMapper.class);
		fvbUserMapper.addUser("hehehe", "123456", "3333133","je@hotmail.com", null);
		System.out.println("success!");
	}
}
