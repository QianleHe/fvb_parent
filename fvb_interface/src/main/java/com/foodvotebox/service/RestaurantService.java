package com.foodvotebox.service;

import com.foodvotebox.pojo.FvbRestaurant;

/**
 * Created by FYG on 17/6/25.
 */
public interface RestaurantService {
    boolean findRestaurant(String restaurantName);

    FvbRestaurant getRestaurant(String restaurantName);
}
