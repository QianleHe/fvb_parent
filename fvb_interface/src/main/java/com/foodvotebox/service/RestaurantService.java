package com.foodvotebox.service;

import com.foodvotebox.pojo.FvbEventRestaurant;
import com.foodvotebox.pojo.FvbRestaurant;

import java.util.List;

/**
 * Created by FYG on 17/6/25.
 */
public interface RestaurantService {
    FvbRestaurant findRestaurantByAddr(String restaurantName, String city, String address);

    Long insertRestaurant(String restaurantName, String city, String address, String phone, String price, String rating, String yelpUrl, String imgUrl);

    FvbRestaurant getRestaurantById(Long restaurantId);
}
