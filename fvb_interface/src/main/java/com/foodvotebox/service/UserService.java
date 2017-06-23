package com.foodvotebox.service;

import com.foodvotebox.pojo.FvbUser;

public interface UserService {
	FvbUser queryById(long userId);

	boolean updatePassword(long userId, String newPassword, String oldPassword);
}
