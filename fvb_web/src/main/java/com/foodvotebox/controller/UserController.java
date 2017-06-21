package com.foodvotebox.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("")
//@ComponentScan("com.foodvotebox.service")
public class UserController {
	@Autowired
	public UserService userService;

	@Autowired
	public LoginService loginService;

	@Autowired(required = false)
	public FvbUserMapper fvbUserMapper;

	public Logger logger = Logger.getAnonymousLogger();
	
	@RequestMapping("/test")
	public String queryById(HttpServletRequest request) throws Exception{
		FvbUser user = userService.queryById(9);
		request.setAttribute("FvbUser", user);
		return "test";
	}

	@RequestMapping("/")
	public String index() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(FvbUser user, HttpSession session) throws Exception {
	    logger.log(Level.INFO, "------Run the login function------");
		boolean loginType = loginService.login(user.getEmail(), user.getUsername(), user.getPassword());
		if (loginType) {
			FvbUser newUser = fvbUserMapper.queryByEmail(user.getEmail()) == null ? fvbUserMapper.queryByUserName(user.getUsername()) : fvbUserMapper.queryByEmail(user.getEmail());
			session.setAttribute("newUser", newUser);
			logger.log(Level.INFO, "login successfully");
			return "redirect: user/" + newUser.getUserId();
		}

		return "error";
	}

	@RequestMapping("user/{userId}")
	public String doSuccess(@PathVariable("userId") long userId, ModelAndView model) {
		FvbUser user = fvbUserMapper.queryById(userId);
		model.addObject("user", user);
		return "loginSuccess";
	}
}
