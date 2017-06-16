package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbUser;

public interface FvbUserMapper {
	FvbUser queryById(long userId);
}
