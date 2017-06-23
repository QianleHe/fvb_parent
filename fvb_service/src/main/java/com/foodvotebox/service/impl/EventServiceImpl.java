package com.foodvotebox.service.impl;

import com.foodvotebox.mapper.FvbEventMapper;
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

    @Autowired
    public FvbEventMapper fvbEventMapper;

    public Logger logger = Logger.getAnonymousLogger();

    @Override
    public void createEvent(String userId, String eventName, String eventDate) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
        logger.log(Level.INFO, userId);
        logger.log(Level.INFO, eventName);
        logger.log(Level.INFO, eventDate);
        fvbEventMapper.createEvent(userId, eventName, eventDate);
    }

    @Override
    public boolean deleteEvent() {
        return false;
    }
}
