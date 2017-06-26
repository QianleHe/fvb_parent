package com.foodvotebox.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodvotebox.mapper.FvbEventMapper;
import com.foodvotebox.mapper.FvbEventRestaurantMapper;
import com.foodvotebox.mapper.FvbRestaurantMapper;
import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbEvent;
import com.foodvotebox.pojo.FvbRestaurant;
import com.foodvotebox.service.EventService;
import com.foodvotebox.service.LoginService;
import com.foodvotebox.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired(required = false)
    public FvbRestaurantMapper fvbRestaurantMapper;

    @Autowired
    @Qualifier(value = "restaurantService")
    public RestaurantService restaurantService;

    @Autowired(required = false)
    public FvbEventRestaurantMapper fvbEventRestaurantMapper;

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

    //owner可以添加，浏览，可以在上一步的时候先把owner加进eventMember表里
    //member可以浏览，如果不是member可以做成直接回到个人界面弹窗
    @RequestMapping("event{eventId}")
    public String eventDisplay(@PathVariable("eventId") Long eventId, HttpSession session, Map<String, Object> model) {
        FvbEvent event = fvbEventMapper.queryById(eventId);
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        model.put("user", user);
        model.put("event", event);
        //if (userId在member表里) ｛return eventPage;｝
        if (event.getOwnerId() == user.getUserId()) {
            //return "eventPage?..."
        }
        logger.log(Level.INFO, event.toString());
        return "eventPage";
    }

    @RequestMapping("event{eventId}/deleteEvent")
    public String deleteEvent(@PathVariable("eventId") Long eventId, HttpSession session) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        fvbEventMapper.deleteEvent(eventId);
        return "redirect:/" + user.getUsername();
    }

    @RequestMapping("event{eventId}/validRestName")
    public @ResponseBody boolean validRestName(HttpServletRequest request, HttpServletResponse response) {
        logger.log(Level.INFO, request.getParameter("restaurantName"));
        boolean result = restaurantService.findRestaurant(request.getParameter("restaurantName"));
        //System.out.println(result + "@#KjjkHKJKJDBFJKDSFJKBJKDF");
        return result;
    }

    @RequestMapping(value = "event{eventId}/addRestaurant", method = RequestMethod.POST)
    public @ResponseBody FvbRestaurant addRestaurant(@PathVariable("eventId") Long eventId, HttpServletRequest request, HttpServletResponse response) {
        FvbRestaurant restaurant = restaurantService.getRestaurant(request.getParameter("restaurantName"));
        logger.log(Level.INFO, restaurant.toString());
        logger.log(Level.INFO, eventId.toString());
        eventService.insertEventRestaurant(eventId, restaurant.getRestaurantId());
        //fvbEventRestaurantMapper.insertRestaurant(eventId, restaurant.getRestaurantId());
        return restaurant;
    }
}
