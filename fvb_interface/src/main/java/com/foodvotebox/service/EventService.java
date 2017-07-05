package com.foodvotebox.service;

import com.foodvotebox.pojo.*;

import java.util.List;

/**
 * Created by FYG on 17/6/22.
 */
public interface EventService {
    FvbEvent getEventById(Long eventId);

    Long createEvent(Long userId, String eventName, String eventDate, String description);

    void deleteEvent(Long eventId);

    void insertEventRestaurant(Long eventId, Long restaurantId);

    boolean findEventRestaurant(Long eventId, Long restaurantId);

    void insertEventMember(Long eventId, Long memberId);

    boolean findEventMember(Long eventId, Long memberId);

    List<DBEventMemberReturnType> findAllMembers(Long eventId);

    void deleteEventMember(Long eventId, Long memberId);

    List<DBEventReturnType> getAllEventsByUserId(Long userId);

    List<DBEventRestaurantReturnType> getAllRestaurant(Long eventId);

    void deleteEventRestaurant(Long eventId, Long restaurantId);

    DBEventMemberReturnType getEventMember(Long userId, Long eventId);

    void updateVoteStatus(Long eventId, Long memberId);

    void updateVotes(Long eventId, Long restaurantId);
}
