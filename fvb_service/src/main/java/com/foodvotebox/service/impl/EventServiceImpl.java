package com.foodvotebox.service.impl;

import com.foodvotebox.mapper.FvbEventMapper;
import com.foodvotebox.mapper.FvbEventMemberMapper;
import com.foodvotebox.mapper.FvbEventRestaurantMapper;
import com.foodvotebox.pojo.*;
import com.foodvotebox.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by FYG on 17/6/22.
 */
@Service(value = "eventService")
public class EventServiceImpl implements EventService, Serializable {


    @Autowired(required = false)
    public FvbEventMapper fvbEventMapper;

    @Autowired(required = false)
    public FvbEventRestaurantMapper fvbEventRestaurantMapper;

    @Autowired(required = false)
    public FvbEventMemberMapper fvbEventMemberMapper;

    public Logger logger = Logger.getAnonymousLogger();

    @Override
    public Long createEvent(Long userId, String eventName, String eventDate, String description) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
        //logger.log(Level.INFO, userId);
        logger.log(Level.INFO, eventName);
        logger.log(Level.INFO, eventDate);
        //return fvbEventMapper.createEvent(userId, eventName, eventDate, description);
        FvbEvent newEvent = new FvbEvent();
        newEvent.setEventName(eventName);
        newEvent.setEventDate(eventDate);
        newEvent.setDescription(description);
        newEvent.setOwnerId(userId);
        fvbEventMapper.createEventAndGetId(newEvent);
        return newEvent.getEventId();
    }

    @Override
    public List<DBEventReturnType> getAllEventsByUserId(Long userId) {
        return fvbEventMapper.getAllEventsByUserId(userId);
    }

    @Override
    public FvbEvent getEventById(Long eventId) {
        return fvbEventMapper.queryById(eventId);
    }

    @Override
    public void insertEventRestaurant(Long eventId, Long restaurantId) {
        fvbEventRestaurantMapper.insertRestaurant(eventId, restaurantId);
    }

    @Override
    public boolean findEventRestaurant(Long eventId, Long restaurantId) {
        FvbEventRestaurant eventRestaurant = fvbEventRestaurantMapper.findEventRestaurant(eventId, restaurantId);
        if (eventRestaurant == null) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteEventRestaurant(Long eventId, Long restaurantId) {
        fvbEventRestaurantMapper.deleteEventRestaurant(eventId, restaurantId);
    }

    @Override
    public void insertEventMember(Long eventId, Long memberId) {
        fvbEventMemberMapper.insertMember(eventId, memberId);
    }

    @Override
    public boolean findEventMember(Long eventId, Long memberId) {
        FvbEventMember eventMember = fvbEventMemberMapper.findEventMember(eventId, memberId);
        if (eventMember == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<DBEventMemberReturnType> findAllMembers(Long eventId) {
        List<DBEventMemberReturnType> result = fvbEventMemberMapper.findAllMembers(eventId);
        return result;
    }

    @Override
    public void deleteEventMember(Long eventId, Long memberId) {
        fvbEventMemberMapper.deleteEventMember(eventId, memberId);
    }

    //删除失败？exception？数据库有问题需要抛exception不
    @Override
    public void deleteEvent(Long eventId) {
        fvbEventMapper.deleteEvent(eventId);
    }

    @Override
    public List<DBEventRestaurantReturnType> getAllRestaurant(Long eventId) {
        List<DBEventRestaurantReturnType> result = fvbEventRestaurantMapper.getAllRestaurant(eventId);
        return result;
    }
}
