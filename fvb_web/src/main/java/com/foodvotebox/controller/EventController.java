package com.foodvotebox.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.foodvotebox.mapper.FvbEventMapper;
import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbEvent;
import com.foodvotebox.service.EventService;
import com.foodvotebox.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
/**
 * Created by FYG on 17/6/22.
 */
@Controller
@RequestMapping("")
public class EventController {
    @Autowired
    @Qualifier(value = "eventService")
    public EventService eventService;

    @Autowired(required = false)
    public FvbEventMapper fvbEventMapper;

    public Logger logger = Logger.getAnonymousLogger();

    @RequestMapping("/listEvent")
    public String listEvent() {
        return "listEvent";
    }

    //能不能直接跳到／fvb_web/event{eventId},action怎么写成变量，不然好难受啊，url不一样
    @RequestMapping(value = "/listSuccess", method = RequestMethod.POST)
    public String listSuccess(FvbEvent event, HttpSession session) {
        logger.log(Level.INFO, event.toString());
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        if (user != null) {
            logger.log(Level.INFO, user.getUserId().toString());
            Long eventId = eventService.createEvent(user.getUserId(), event.getEventName(), event.getEventDate(), event.getDescription());
            //logger.log(Level.INFO, eventId.toString());
            return "redirect:event" + eventId.toString();
        }
        return "error";
    }

    //eventId应该是long?
    @RequestMapping("event{eventId}")
    public String eventDisplay(@PathVariable("eventId") Long eventId, HttpSession session, Map<String, Object> model) {
        FvbEvent event = fvbEventMapper.queryById(eventId);
        logger.log(Level.INFO, event.toString());
        return "eventPage";
    }
}
