package com.foodvotebox.service;

import java.util.Date;

/**
 * Created by FYG on 17/6/22.
 */
public interface EventService {
    void createEvent(String userId, String eventName, String eventDate);

    public boolean deleteEvent();
}
