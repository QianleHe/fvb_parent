package com.foodvotebox.service;

import com.FoodVoteBox.exception.AddAsFavouriteEnum;
import com.foodvotebox.pojo.FvbRestaurant;

import java.util.List;

/**
 * Created by qianle on 7/3/17.
 */
public interface AddRestaurantAsFavouriteService {

    AddAsFavouriteEnum addRestaurantAsFavouriteService(long userId, FvbRestaurant restaurant);

    AddAsFavouriteEnum removeFavouriteRestaurant(long userId, long retaurantId);

    List<FvbRestaurant> listAllFavourite(long userId);
}
