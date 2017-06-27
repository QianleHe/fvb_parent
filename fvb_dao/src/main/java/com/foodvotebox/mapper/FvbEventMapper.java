package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbEvent;
import org.apache.ibatis.annotations.Param;

/**
 * Created by FYG on 17/6/22.
 */
public interface FvbEventMapper {
    //Long createEvent(@Param("userId") String userId, @Param("eventName") String eventName, @Param("eventDate") String eventDate, @Param("description") String description);

    Long createEventAndGetId(FvbEvent event);

    void deleteEvent(Long eventId);

    FvbEvent queryById(Long eventId);
}
