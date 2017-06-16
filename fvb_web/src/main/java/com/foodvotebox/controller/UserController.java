package com.foodvotebox.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.UserService;

@Controller
@RequestMapping("")
//@ComponentScan("com.foodvotebox.service")
public class UserController {
	@Autowired
	public UserService userService;
	
	@RequestMapping("/test")
	public String queryById(HttpServletRequest request) throws Exception{
		System.out.println("aaaa");
		FvbUser user = userService.queryById(9);
		request.setAttribute("FvbUser", user);
		System.out.println(user);
		return "index";
	}
}
