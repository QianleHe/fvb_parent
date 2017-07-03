package com.foodvotebox.service.impl;

import com.foodvotebox.mapper.FvbRestaurantMapper;
import com.foodvotebox.pojo.FvbRestaurant;
import com.foodvotebox.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by FYG on 17/6/25.
 */
@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired(required = false)
    public FvbRestaurantMapper fvbRestaurantMapper;

    public Logger logger = Logger.getAnonymousLogger();


//    //这两个方法其实可以改成一个
//    @Override
//    public boolean findRestaurant(String restaurantName) {
//        if (fvbRestaurantMapper.queryByName(restaurantName) != null) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public FvbRestaurant getRestaurant(String restaurantName) {
//        FvbRestaurant restaurant = fvbRestaurantMapper.queryByName(restaurantName);
//        return restaurant;
//    }
}
