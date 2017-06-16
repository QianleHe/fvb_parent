package com.foodvotebox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private FvbUserMapper fvbUserMapper;
	
	@Override
	public FvbUser queryById(long userId) {
		FvbUser user = fvbUserMapper.queryById(userId);
		return user;
	}

}
