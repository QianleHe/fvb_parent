package com.foodvotebox.serviceTest;

import com.FoodVoteBox.yelpApi.GetRestaurant;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by qianle on 6/26/17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "")
public class yelpApiTest {

    //@Autowired
    //@Qualifier(value = "getRes")
    //public GetRestaurant getRes;

    @Test
    public void test() {
        //JSONObject object = getRes.getRes("HOTPOT", "SEATTLE","1",2);
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        GetRestaurant restaurant = context.getBean(GetRestaurant.class);
        JSONObject object = restaurant.getRes("HOTPOT","SEATTLE", "1",2);
        //JSONObject object1 = restaurant.getRes("KFC","NEW YORK", "0", "0",500,)
        System.out.println(object.toString());
    }
}
