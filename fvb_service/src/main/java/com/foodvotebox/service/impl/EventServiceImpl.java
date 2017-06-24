package com.foodvotebox.service.impl;

import com.foodvotebox.mapper.FvbEventMapper;
import com.foodvotebox.pojo.FvbEvent;
import com.foodvotebox.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by FYG on 17/6/22.
 */
@Service(value = "eventService")
public class EventServiceImpl implements EventService, Serializable {

    @Autowired(required = false)
    public FvbEventMapper fvbEventMapper;

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
    public boolean deleteEvent() {
        return false;
    }
}
