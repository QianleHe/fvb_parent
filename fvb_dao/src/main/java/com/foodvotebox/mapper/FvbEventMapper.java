package com.foodvotebox.mapper;

import com.foodvotebox.pojo.DBEventMemberReturnType;
import com.foodvotebox.pojo.DBEventReturnType;
import com.foodvotebox.pojo.FvbEvent;
import com.foodvotebox.pojo.FvbRestaurant;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by FYG on 17/6/22.
 */
public interface FvbEventMapper {
    //Long createEvent(@Param("userId") String userId, @Param("eventName") String eventName, @Param("eventDate") String eventDate, @Param("description") String description);

    Long createEventAndGetId(FvbEvent event);

    void deleteEvent(Long eventId);

    FvbEvent queryById(Long eventId);

    List<DBEventReturnType> getAllEventsByUserId(@Param("userId") Long userId);

    void updateSubmitStatus(@Param("eventId") Long eventId);

    List<FvbEvent> getFinishedEventByEndTime();

    void updateEventResult(@Param("eventId") Long eventId, @Param("resultId") Long resultId);
}
