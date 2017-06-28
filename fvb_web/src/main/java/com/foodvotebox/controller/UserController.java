package com.foodvotebox.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.service.FvbFriendService;
import com.foodvotebox.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.UserService;

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

	@Autowired
	@Qualifier(value = "friendService")
	private FvbFriendService fvbFriendService;

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
				return "redirect:" + user.getUsername();
			}
		}
		return "login";
	}

	@RequestMapping("/login")
	public String login(FvbUser user, HttpSession session) throws Exception {
		logger.log(Level.INFO, "------Run the login function------");
		logger.log(Level.INFO, user.getEmail());
		if (session != null) {
			FvbUser curUser = (FvbUser)session.getAttribute("newUser");
			if (curUser != null) {
				return "redirect:" + curUser.getUsername();
			}
		}
		boolean loginType = loginService.login(user.getEmail(), user.getEmail(), user.getPassword());
		if (loginType) {
			FvbUser newUser = fvbUserMapper.queryByEmail(user.getEmail()) == null ? fvbUserMapper.queryByUserName(user.getEmail()) : fvbUserMapper.queryByEmail(user.getEmail());
			session.setAttribute("newUser", newUser);
			logger.log(Level.INFO, "login successfully");
			return "redirect:" + newUser.getUsername();
		}


		return "error";
	}

	@RequestMapping("{username}")
	public String doSuccess(@PathVariable("username") String username, HttpSession session, Map<String, Object> model) {
		FvbUser user = (FvbUser)session.getAttribute("newUser");
		if (user.getUserId() == fvbUserMapper.queryByUserName(username).getUserId()) {
			//如果ID不同，应该可以浏览但不能修改信息，之后可以加个权限
			logger.log(Level.INFO, user.toString());
			model.put("user", user);
			return "loginSuccess";
		}
		logger.log(Level.INFO, "You can only visit your profile");
		return "redirect:" + user.getUsername();
	}


	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register/do", method = RequestMethod.POST)
	public  String doRegister(FvbUser user) {
		//logger.log(Level.INFO, user.getFriendname());
		loginService.register(user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail());
		//loginService.register("hehehe", user.getPassword(), user.getEmail(), user.getPhone());
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("newUser");
		return "login";
	}

	// get json data when you click check button
	@RequestMapping("/userInfo")
	@ResponseBody
	public FvbUser showInfo(HttpSession session) {
		FvbUser user = (FvbUser)session.getAttribute("newUser");
		return user;
	}

	@RequestMapping("/updateUser")
	public String gotoUserUpdate(HttpSession session, Map<String, Object> model) {
	    if (session == null) return "login";
	    else {
	        FvbUser user = (FvbUser)session.getAttribute("newUser");
	        model.put("user", user);
        }
		return "userInfoRevise";
	}

	@RequestMapping("/doUpdate")
	public String doUpdate(HttpSession session, FvbUser user, Map<String, Object> model) {
	    if (session == null) return "login";
	    FvbUser storedUser = (FvbUser)session.getAttribute("newUser");
	    fvbUserMapper.updateUser(storedUser.getUserId(), user.getUsername(), user.getPhone(), user.getEmail());
        logger.log(Level.INFO, storedUser.getUserId().toString());
        FvbUser updatedUser = userService.queryById(storedUser.getUserId());
	    session.setAttribute("newUser", updatedUser);
	    model.put("user", updatedUser);
		return "loginSuccess";
	}

	@RequestMapping("/updatePassword")
    public String gotoPasswordUpdate(HttpSession session, Map<String, Object> model) {
	    if (session == null) return "login";
	    else {

        }
	    return "userPasswordRevise";
    }

    @RequestMapping("/updatePassword/do")
    public String doUpdatePassword(HttpSession session, @RequestParam("newpassword") String newPassword, @RequestParam("oldpassword") String oldPassword, Map<String, Object> model) {
	    if (session == null){
	    	return "login";
		}
		if (newPassword == null || newPassword.length() == 0) return "error"; // 当你要改的密码的内容是null的话，就报错
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        logger.log(Level.INFO, newPassword);
        if (userService.updatePassword(user.getUserId(), newPassword, oldPassword)) {
            logger.log(Level.INFO,"update has been called");
//            session.removeAttribute("newUser"); //when it success, remove the login state and jump to login page again
//            return "login";
            // renew the session, jump to personal page
            FvbUser revisedUser = userService.queryById(user.getUserId());
            session.setAttribute("newUser", revisedUser);
            model.put("user", revisedUser);
            return "loginSuccess";
        }
        return "login";
    }

    @RequestMapping("/addFriend")
    public String gotoAddFriend(HttpSession session){
		if (session == null){
			return "login";
		}
		return "addFriend";
	}
	@RequestMapping("/addFriend/do")
    public String doAddFriend(HttpSession session, @RequestParam("friendname") String friendName, Map<String,Object> model){
		if (session == null){
			return "login";
		}
		FvbUser user = (FvbUser) session.getAttribute("newUser");
		if (user != null && !fvbFriendService.cannotAddFriend(user.getUserId(),friendName)) {
			fvbFriendService.addFriend(user.getUserId(), friendName);
		}
		model.put("user",user);
		return "loginSuccess";
	}
}