package com.foodvotebox.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodvotebox.mapper.FvbEventMapper;
import com.foodvotebox.mapper.FvbEventRestaurantMapper;
import com.foodvotebox.mapper.FvbRestaurantMapper;
import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.*;
import com.foodvotebox.service.EventService;
import com.foodvotebox.service.LoginService;
import com.foodvotebox.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodvotebox.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
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
    public FvbUserMapper fvbUserMapper;

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
            eventService.insertEventMember(eventId, user.getUserId());
            return "redirect:listEvent" + eventId.toString();
        }
        return "error";
    }


    //owner可以添加，浏览，可以在上一步的时候先把owner加进eventMember表里
    //member可以浏览，如果不是member可以做成直接回到个人界面弹窗
    @RequestMapping("listEvent{eventId}")
    public String eventDisplay(@PathVariable("eventId") Long eventId, HttpSession session, Map<String, Object> model, HttpServletRequest request) {
        FvbEvent event = fvbEventMapper.queryById(eventId);
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        if (user.getUserId() != eventService.getEventById(eventId).getOwnerId()) {
            return "redirect:/" + user.getUsername();
        }
        List<DBEventMemberReturnType> members = eventService.findAllMembers(eventId);
        request.setAttribute("memberList", members);
        model.put("memberList", members);
        model.put("user", user);
        model.put("event", event);
        //if (userId在member表里) ｛return eventPage;｝
//        if (event.getOwnerId() == user.getUserId()) {
//            //return "eventPage?..."
//        }
        logger.log(Level.INFO, event.toString());
        return "eventPage";
    }

    @RequestMapping("listEvent{eventId}/deleteEvent")
    public String deleteEvent(@PathVariable("eventId") Long eventId, HttpSession session) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        if (user.getUserId() != eventService.getEventById(eventId).getOwnerId()) {
            return "redirect:/" + user.getUsername();
        }
        fvbEventMapper.deleteEvent(eventId);
        return "redirect:/" + user.getUsername();
    }

    @RequestMapping(value = "listEvent{eventId}/addRestaurant", method = RequestMethod.POST)
    public @ResponseBody List<DBEventRestaurantReturnType> addRestaurant(@PathVariable("eventId") Long eventId, HttpServletRequest request, HttpServletResponse response) {
        String restaurantName = request.getParameter("restaurantName");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String price = request.getParameter("price");
        String rating = request.getParameter("rating");
        String yelpUrl = request.getParameter("yelpUrl");
        String imgUrl = request.getParameter("imgUrl");
        System.out.println(restaurantName +"     "+city + "     "+ address);
        FvbRestaurant restaurant = restaurantService.findRestaurantByAddr(restaurantName, city, address);
        if (restaurant == null) {
            Long restaurantId = restaurantService.insertRestaurant(restaurantName, city, address, phone, price, rating, yelpUrl, imgUrl);
            eventService.insertEventRestaurant(eventId, restaurantId);
        } else if (eventService.findEventRestaurant(eventId, restaurant.getRestaurantId())) {
            eventService.insertEventRestaurant(eventId, restaurant.getRestaurantId());
        }
        List<DBEventRestaurantReturnType> restaurants = eventService.getAllRestaurant(eventId);
        return restaurants;
    }

    @RequestMapping(value = "listEvent{eventId}/deleteRestaurant")
    public @ResponseBody Object deleteRestaurant(@PathVariable("eventId") Long eventId, HttpServletRequest request, HttpServletResponse response) {
        String temp = request.getParameter("restaurantId");
        Long restaurantId = Long.valueOf(temp);
        eventService.deleteEventRestaurant(eventId, restaurantId);
        List<DBEventRestaurantReturnType> restaurants = eventService.getAllRestaurant(eventId);
        return restaurants;
    }


    @RequestMapping("listEvent{eventId}/validMemberName")
    public @ResponseBody boolean validMemberName(@PathVariable("eventId") Long eventId, HttpServletRequest request, HttpServletResponse response) {
        logger.log(Level.INFO, request.getParameter("memberName"));
        FvbUser user = fvbUserMapper.queryByUserName(request.getParameter("memberName"));
        if (user != null) {
            if (eventService.findEventMember(eventId, user.getUserId())) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "listEvent{eventId}/addMember", method = RequestMethod.POST)
    public @ResponseBody Object addMember(@PathVariable("eventId") Long eventId, HttpServletRequest request, HttpServletResponse response) {
        FvbUser user = fvbUserMapper.queryByUserName(request.getParameter("memberName"));
//        if (user == null ||
//                !eventService.findEventMember(eventId, user.getUserId())) {
//            return new String("false");
//        }
        eventService.insertEventMember(eventId, user.getUserId());
        List<DBEventMemberReturnType> members = eventService.findAllMembers(eventId);
        return members;
    }

    //只有owner可以delete
    //owner不能delete自己
    @RequestMapping(value = "listEvent{eventId}/deleteMember", method = RequestMethod.GET)
    public @ResponseBody Object deleteMember(@PathVariable("eventId") Long eventId, HttpServletRequest request, HttpServletResponse response) {
        String temp = request.getParameter("memberId");
        System.out.println(temp);
        Long memberId = Long.valueOf(temp);
        if (memberId == eventService.getEventById(eventId).getOwnerId()) {
            List<DBEventMemberReturnType> members = eventService.findAllMembers(eventId);
            return members;
        }
        eventService.deleteEventMember(eventId, memberId);
        List<DBEventMemberReturnType> members = eventService.findAllMembers(eventId);
        return members;
    }

    @RequestMapping(value = "listEvent{eventId}/displayMember", method = RequestMethod.GET)
    public @ResponseBody Object displayMember(@PathVariable("eventId") Long eventId, HttpServletRequest request, HttpServletResponse response) {
        List<DBEventMemberReturnType> members = eventService.findAllMembers(eventId);
        return members;
    }

    @RequestMapping("event{eventId}")
    public String votePage(@PathVariable("eventId") Long eventId, HttpSession session, Map<String, Object> model, HttpServletRequest request) {
        FvbEvent event = fvbEventMapper.queryById(eventId);
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        if (eventService.findEventMember(eventId, user.getUserId())){
            //you are not in this event(JS显示)
            return "redirect:" + user.getUsername();
        }
        List<DBEventMemberReturnType> members = eventService.findAllMembers(eventId);
        request.setAttribute("memberList", members);
        model.put("memberList", members);
        model.put("user", user);
        model.put("event", event);
        //if (userId在member表里) ｛return eventPage;｝
//        if (event.getOwnerId() == user.getUserId()) {
//            //return "eventPage?..."
//        }
        logger.log(Level.INFO, event.toString());
        return "votePage";
    }

    @RequestMapping("myEvents")
    public String showMyEvents(Map<String, Object> model, HttpSession session, HttpServletRequest request) {
        FvbUser user = (FvbUser)session.getAttribute("newUser");
        List<DBEventReturnType> events = eventService.getAllEventsByUserId(user.getUserId());
        model.put("eventList", events);
        model.put("user", user);
        request.setAttribute("eventList", events);
        System.out.println(events);
        return "eventList";
    }

}
