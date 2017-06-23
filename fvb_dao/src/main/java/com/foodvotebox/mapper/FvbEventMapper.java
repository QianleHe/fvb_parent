package com.foodvotebox.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by FYG on 17/6/22.
 */
public interface FvbEventMapper {
    void createEvent(@Param("userId") String userId, @Param("eventName") String eventName, @Param("eventDate") String eventDate, @Param("description") String description);
}
