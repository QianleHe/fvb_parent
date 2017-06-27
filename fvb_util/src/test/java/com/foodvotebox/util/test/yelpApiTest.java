package com.foodvotebox.util.test;

import com.FoodVoteBox.yelpApi.GetRestaurant;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by qianle on 6/26/17.
 */

public class yelpApiTest {
    GetRestaurant restaurant = new GetRestaurant();

    @Test
    public void test() {
        JSONObject object = restaurant.getRes("HOTPOT","SEATTLE","2",1);
        System.out.println(object.toString());
    }
}
