package com.foodvotebox.mapper;

import com.foodvotebox.pojo.DBEventRestaurantReturnType;
import com.foodvotebox.pojo.FvbEventRestaurant;
import com.foodvotebox.pojo.FvbRestaurant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by FYG on 17/6/25.
 */
public interface FvbEventRestaurantMapper {
    void insertRestaurant(@Param("eventId") Long eventId, @Param("restaurantId") Long restaurantId);

    FvbEventRestaurant findEventRestaurant(@Param("eventId") Long eventId, @Param("restaurantId") Long restaurantId);

    List<DBEventRestaurantReturnType> getAllRestaurant(Long eventId);

    void deleteEventRestaurant(@Param("eventId") Long eventId, @Param("restaurantId") Long restaurantId);

    void updateVotes(@Param("eventId") Long eventId, @Param("restaurantId") Long restaurantId);
}
