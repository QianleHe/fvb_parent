package com.foodvotebox.controller;

import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbFriend;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.FvbFriendService;
import com.foodvotebox.service.UserService;
import com.sun.corba.se.impl.io.FVDCodeBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by wuqi on 6/28/17.
 */
@Controller
@RequestMapping("")
public class FriendController {
    @Autowired
    private FvbFriendService fvbFriendService;
    @Autowired(required = false)
    private FvbUserMapper fvbUserMapper;

    private Logger log = Logger.getAnonymousLogger();

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
    @RequestMapping("/deleteFriend")
    public String gotoDeleteFriend(HttpSession session){
        if (session == null){
            return "login";
        }
        return "deleteFriend";
    }
    @RequestMapping("/deleteFriend/do")
    public String doDeleteFriend(HttpSession session, @RequestParam("friendname") String friendName, Map<String,Object> model){
        if (session == null){
            return "login";
        }
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        if (user!= null){
            fvbFriendService.deleteFriend(user.getUserId(),friendName);
        }
        model.put("user",user);
        return "loginSuccess";
    }
    @RequestMapping("/checkFriend")
    @ResponseBody
    public boolean checkFriend(HttpServletRequest request, HttpServletResponse response){
        String friendInput = request.getParameter("friendInput");
        FvbUser fvbUser = fvbUserMapper.queryByUserName(friendInput);
        if (fvbUser == null){
            FvbUser fvbUserByEmail = fvbUserMapper.queryByEmail(friendInput);
            return fvbUserByEmail != null;
        } else{
            return true;
        }
    }

    @RequestMapping("displayFriend")
    public String friendDisplay(HttpSession session, Map<String, Object> model, HttpServletRequest request) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        if (user == null) {
            return "login";
        }
        List<FvbFriend> friends = fvbFriendService.displayFriend(user.getUserId());
        request.setAttribute("friendList", friends);
        model.put("friendList", friends);
        model.put("user", user);
        return "deleteFriend";
    }

    @RequestMapping(value = "deleteFriend", method = RequestMethod.GET)
    public @ResponseBody Object deleteMember(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String temp = request.getParameter("friendId");
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        Long friendId = Long.valueOf(temp);
        fvbFriendService.deleteFriend(user.getUserId(),friendId);
        List<FvbFriend> friends = fvbFriendService.displayFriend(user.getUserId());
        return friends;
    }
    @RequestMapping("/addFriend/bool")
    public @ResponseBody Object addFriend(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        String friendInput = request.getParameter("friendInput");
        if (user != null && !fvbFriendService.cannotAddFriend(user.getUserId(),friendInput)) {
            fvbFriendService.addFriend(user.getUserId(), friendInput);
        }
        List<FvbFriend> friends = fvbFriendService.displayFriend(user.getUserId());
        return friends;
    }
//    /**
//     * display friend method, return friend list
//     * @param session
//     * @param model
//     * @return
//     */
//    @RequestMapping("/displayFriend")
//    public @ResponseBody List<FvbFriend> displayFriend(HttpSession session, Map<String, Object> model){
//        FvbUser user = (FvbUser) model.get("user");
//        if (user != null){
//            return fvbFriendService.displayFriend(user.getUserId());
//        }
//        return null;
//    }
}
