package com.foodvotebox.controller;

import com.FoodVoteBox.yelpApi.GetRestaurant;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qianle on 6/26/17.
 */

@Controller
@RequestMapping("")
//@Configuration(value = "spring/ApplicationContext-dao.xml")
public class YelpRestaurantController {

    //@Autowired
    //@Qualifier(value = "getRestaurant")
    //public GetRestaurant getRestaurant;

    @RequestMapping("/restaurant")
    public String getResList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
        GetRestaurant getRestaurant = context.getBean(GetRestaurant.class);
        JSONObject object = getRestaurant.getRes("HOTPOT", "WA","1",1);
        System.out.println(object.toString());
        return "";
    }
}
