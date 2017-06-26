package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbEventRestaurant;
import org.apache.ibatis.annotations.Param;

/**
 * Created by FYG on 17/6/25.
 */
public interface FvbEventRestaurantMapper {
    void insertRestaurant(@Param("eventId") Long eventId, @Param("restaurantId") Long restaurantId);

    FvbEventRestaurant findEventRestaurant(@Param("eventId") Long eventId, @Param("restaurantId") Long restaurantId);
}
