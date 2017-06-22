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
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
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
	public String index(HttpSession session) {
		if (session != null) {
			FvbUser user = (FvbUser)session.getAttribute("newUser");
			if (user != null) {
				boolean loginType = loginService.login(user.getEmail(), user.getEmail(), user.getPassword());
				return "redirect: user/" + user.getUserId();
			}
		}
		return "login";
	}

	@RequestMapping("/login")
	public String login(FvbUser user, HttpSession session) throws Exception {
	    logger.log(Level.INFO, "------Run the login function------");
	    logger.log(Level.INFO, user.getEmail());
		boolean loginType = loginService.login(user.getEmail(), user.getEmail(), user.getPassword());
		if (loginType) {
			FvbUser newUser = fvbUserMapper.queryByEmail(user.getEmail()) == null ? fvbUserMapper.queryByUserName(user.getEmail()) : fvbUserMapper.queryByEmail(user.getEmail());
			session.setAttribute("newUser", newUser);
			logger.log(Level.INFO, "login successfully");
			return "redirect: user/" + newUser.getUserId();
		}

		return "error";
	}

	@RequestMapping("user/{userId}")
	public String doSuccess(@PathVariable("userId") long userId, Map<String, Object> model) {
		FvbUser user = fvbUserMapper.queryById(userId);
		logger.log(Level.INFO, user.toString());
        // model.addObject("user", user);
        model.put("user", user);
		return "loginSuccess";
	}


	@RequestMapping("/register")
    public String register() {
	    return "register";
    }

    @RequestMapping(value = "/register/do", method = RequestMethod.POST)
    public  String doRegister(FvbUser user) {
	    //logger.log(Level.INFO, user.getUsername());
	    loginService.register(user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail());
        //loginService.register("hehehe", user.getPassword(), user.getEmail(), user.getPhone());
	    return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
	    session.removeAttribute("newUser");
	    return "login";
    }
}
