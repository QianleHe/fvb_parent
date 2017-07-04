package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbRestaurant;
import org.apache.ibatis.annotations.Param;

/**
 * Created by FYG on 17/6/25.
 */
public interface FvbRestaurantMapper {
    FvbRestaurant findRestaurantByAddr(@Param("restaurantName")String restaurantName, @Param("city")String city, @Param("address")String address);

    Long insertRestaurant(FvbRestaurant restaurant);
}
