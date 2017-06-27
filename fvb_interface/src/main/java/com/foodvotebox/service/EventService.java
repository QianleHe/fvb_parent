package com.foodvotebox.service;

import java.util.Date;

/**
 * Created by FYG on 17/6/22.
 */
public interface EventService {
    Long createEvent(Long userId, String eventName, String eventDate, String description);

    void deleteEvent(Long eventId);

    void insertEventRestaurant(Long eventId, Long restaurantId);

    boolean findEventRestaurant(Long eventId, Long restaurantId);

    void insertEventMember(Long eventId, Long memberId);

    boolean findEventMember(Long eventId, Long memberId);
}
