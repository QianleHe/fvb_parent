package com.foodvotebox.controller;

import com.FoodVoteBox.exception.MessageStatusEnum;
import com.foodvotebox.pojo.FvbMessage;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by qianle on 7/5/17.
 */
@Component
@RequestMapping("/")
public class MessageController {
    @Autowired
    public MessageService messageService;

    @RequestMapping("/getUnreadNumber")
    @ResponseBody
    public String getUnreadNum(HttpSession session) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        return "" + messageService.getUnreadMessages(user.getUserId());
    }

    @RequestMapping("/getAllMessage")
    @ResponseBody
    public List<FvbMessage> getAllMessage(HttpSession session) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        return messageService.getMessageList(user.getUserId(), 0, 20);
    }

    @RequestMapping("/getAllMessageReceived")
    @ResponseBody
    public List<FvbMessage> getAllMessageRecived(HttpSession session) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        return messageService.getAllMessagesReceived(user.getUserId(), 0, 20);
    }

    @RequestMapping("/getAllMessageSent")
    @ResponseBody
    public List<FvbMessage> getAllMessageSent(HttpSession session) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        return messageService.getAllMessagesSent(user.getUserId(), 0, 20);
    }

    @RequestMapping("/updated/user={userId}&msg={msgId}")
    @ResponseBody
    public String updateUnread(@PathVariable("userId") long userId, @PathVariable("msgId") long msgId) {
        MessageStatusEnum e = messageService.updateHasRead(msgId, userId);
        return e.getStateinfo();
    }

    @RequestMapping("/addMessage")
    @ResponseBody
    public String addMessage(FvbMessage message) {
        MessageStatusEnum e = messageService.addMessage(message);
        return e.getStateinfo();
    }
}
