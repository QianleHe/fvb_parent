package com.foodvotebox.service.impl;

import com.FoodVoteBox.util.PasswordChecker;
import com.FoodVoteBox.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.UserService;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class UserServiceImpl implements UserService, Serializable {

	@Autowired(required = false)
	private FvbUserMapper fvbUserMapper;

	Logger logger = Logger.getAnonymousLogger();
	
	@Override
	public FvbUser queryById(long userId) {
		FvbUser user = fvbUserMapper.queryById(userId);
		return user;
	}

	/*
	* 	newPassword ：it is the password which is your new one
	*
	* 	oldPassword : it is the old password which you type in to make sure you want to change the password
	*
	* */
	@Override
	public boolean updatePassword(long userId, String newPassword, String oldPassword) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
		PasswordEncoder encoder = (PasswordEncoder)context.getBean("passwordEncoder");
		PasswordChecker checker = (PasswordChecker) context.getBean("passwordChecker");
		try {
			String pswd = fvbUserMapper.queryById(userId).getPassword();
			if (!checker.checkerPassword(oldPassword, pswd)) {
				return false;
			}
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.INFO, e.toString());
		} catch (UnsupportedEncodingException e) {
			logger.log(Level.INFO, e.toString());
		}
		try {
			newPassword = encoder.EncoderByMd5(newPassword);
		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.INFO, e.toString());
		} catch (UnsupportedEncodingException e) {
			logger.log(Level.INFO, e.toString());
		}
		fvbUserMapper.updatePassword(userId, newPassword);
		return true;
	}
}
