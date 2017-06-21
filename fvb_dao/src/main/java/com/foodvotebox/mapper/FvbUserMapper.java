package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbUser;
import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;


//@Repository
public interface FvbUserMapper {
	FvbUser queryById(long userId);

	FvbUser queryByUserName(String userName);

	FvbUser queryByEmail(String email);

	void addUser(@Param("userName") String userName,@Param("password") String password,@Param("phone") String phone,@Param("email") String email);
}
