package com.foodvotebox.service.impl;

import com.FoodVoteBox.exception.AddAsFavouriteEnum;
import com.foodvotebox.mapper.FvbAddedRestaurantMapper;
import com.foodvotebox.pojo.FvbRestaurant;
import com.foodvotebox.service.AddRestaurantAsFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by qianle on 7/3/17.
 */
@Service(value = "addRestaurantAsFavouriteService")
public class AddRestaurantAsFavouriteServiceImpl implements AddRestaurantAsFavouriteService {

    @Autowired(required = false)
    public FvbAddedRestaurantMapper fvbAddedRestaurantMapper;

    Logger logger = Logger.getAnonymousLogger();

    @Override
    public AddAsFavouriteEnum addRestaurantAsFavouriteService(long userId, FvbRestaurant restaurant) {
        if (restaurant.getCity() == null) restaurant.setCity("");
        if (restaurant.getAddress() == null) restaurant.setAddress("");
        FvbRestaurant restaurantRes = fvbAddedRestaurantMapper.queryRestaurantsByNameCityAddress(restaurant.getRestaurantName(), restaurant.getCity(), restaurant.getAddress());
        if (restaurantRes == null) {
            fvbAddedRestaurantMapper.addRestaurant(restaurant.getRestaurantName(), restaurant.getCity(), restaurant.getAddress(),
                    restaurant.getPhone(), restaurant.getPrice(), restaurant.getRating(), restaurant.getYelpUrl(), restaurant.getImgUrl());
            restaurantRes = fvbAddedRestaurantMapper.queryRestaurantsByNameCityAddress(restaurant.getRestaurantName(), restaurant.getCity(), restaurant.getAddress());
            if (restaurantRes == null) {
                logger.log(Level.INFO, "restaurant cannot be added");
                return AddAsFavouriteEnum.UNKNOWN_ERROR;
            }
        }
        FvbRestaurant temp = fvbAddedRestaurantMapper.queryAddedRestaurant(userId, restaurantRes.getRestaurantId());
        if (temp != null) {
            return AddAsFavouriteEnum.ALREADY_ADDED;
        }
        fvbAddedRestaurantMapper.addRestaurantAsFavourite(userId, restaurantRes.getRestaurantId());
        return AddAsFavouriteEnum.ADD_SUCCESS;
    }

    @Override
    public AddAsFavouriteEnum removeFavouriteRestaurant(long userId, long restaurantId) {
        FvbRestaurant restaurant = fvbAddedRestaurantMapper.queryAddedRestaurant(userId, restaurantId);
        if(restaurant == null) {
            return AddAsFavouriteEnum.NOSUCH_RESTAURANT;
        }
        fvbAddedRestaurantMapper.removeRestaurantFromFavourite(userId, restaurantId);
        if (fvbAddedRestaurantMapper.queryAddedRestaurant(userId, restaurantId) != null) {
            return AddAsFavouriteEnum.UNKNOWN_ERROR;
        }
        return AddAsFavouriteEnum.REMOVE_SUCCESS;
    }

    @Override
    public List<FvbRestaurant> listAllFavourite(long userId) {
        List<FvbRestaurant> list = fvbAddedRestaurantMapper.queryAddedRestaurantsByUserId(userId);
        return list;
    }


}
