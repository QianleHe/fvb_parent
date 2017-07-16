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
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by qianle on 7/5/17.
 */
@Component
@RequestMapping("/")
public class MessageController {
    @Autowired
    public MessageService messageService;

    Logger logger = Logger.getAnonymousLogger();

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
    public String addMessage(FvbMessage message, HttpSession session) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        if (message.getContent() == null) message.setContent("");
        message.setHasRead(0);
        message.setFromId(user.getUserId());
        if (message.getConversationId() == null) message.setConversationId(message.getFromId(), message.getToId());
        logger.log(Level.INFO, message.toString());
        MessageStatusEnum e = messageService.addMessage(message);
        return e.getStateinfo();
    }

    @RequestMapping("/msg")
    public String gotoMessage(){
        return "sendMessageSample";
    }

    @RequestMapping("/getAllMessageUnread")
    @ResponseBody
    public List<FvbMessage> getAllMessageUnread(HttpSession session) {
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        return messageService.getAllMessagesUnread(user.getUserId(), 0, 20);
    }
}
