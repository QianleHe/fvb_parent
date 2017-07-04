package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbRestaurant;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by qianle on 7/2/17.
 */
public interface FvbAddedRestaurantMapper {

    void addRestaurant(@Param("restaurantName") String restaurantName, @Param("city") String city, @Param("address") String address
                            , @Param("phone") String phone, @Param("price") String price, @Param("rating") String rating, @Param("yelpUrl") String yelpUrl
                            , @Param("imgUrl") String imgUrl);

    void addRestaurantAsFavourite(@Param("userId") long userId, @Param("restaurantId") long restaurantId);

    void removeRestaurantFromFavourite(@Param("userId") long userId, @Param("restaurantId") long restaurantId);

    void deleteRestaurant(@Param("restaurantId") long restaurantId);

    FvbRestaurant queryRestaurant(@Param("restaurantId") long restaurantId);

    FvbRestaurant queryAddedRestaurant(@Param("userId") long userId, @Param("restaurantId") long restaurantId);

    List<FvbRestaurant> queryAddedRestaurantsByUserId(@Param("userId") long userId);

    FvbRestaurant queryRestaurantsByNameCityAddress(@Param("restaurantName") String restaurantName, @Param("city") String city, @Param("address") String address);

    List<FvbRestaurant> queryRestaurantsByName(@Param("restaurantName") String restaurantName);


}
