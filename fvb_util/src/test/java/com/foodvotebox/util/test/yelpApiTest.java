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

    @Test
    public void test2() {
        JSONObject object = restaurant.getResByLocation(47.6638866,-122.31430569999999, 1);
        System.out.println(object.toString());
    }

//    @Test
//    public void test3() {
//        JSONObject object = restaurant.getRes("", "seattle",47.6638866,-122.31430569999999,2000,"food",1,1,"best_match","1,2,3",false,"default");
//        System.out.println(object.toString());
//    }
}
