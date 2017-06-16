package com.foodvotebox.service;

import com.foodvotebox.pojo.FvbUser;

public interface UserService {
	public FvbUser queryById(long userId);
}
