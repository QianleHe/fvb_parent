package com.foodvotebox.serviceTest;

import com.FoodVoteBox.exception.AddAsFavouriteEnum;
import com.foodvotebox.mapper.FvbAddedRestaurantMapper;
import com.foodvotebox.pojo.FvbRestaurant;
import com.foodvotebox.service.AddRestaurantAsFavouriteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by qianle on 7/3/17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/spring/ApplicationContext-service.xml")
public class AddAsFavouriteServiceTest {

//    @Autowired
//    public AddRestaurantAsFavouriteService service;

//    @Test
//    public void addTest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        FvbAddedRestaurantMapper fvbAddedRestaurantMapper = context.getBean(FvbAddedRestaurantMapper.class);
//        FvbRestaurant restaurant = new FvbRestaurant();
//        restaurant.setRestaurantName("hahaha");
//        fvbAddedRestaurantMapper.addRestaurantAsFavourite(22, 13);
//    }
//
//    @Test
//    public void removeTest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        FvbAddedRestaurantMapper fvbAddedRestaurantMapper = context.getBean(FvbAddedRestaurantMapper.class);
//        fvbAddedRestaurantMapper.removeRestaurantFromFavourite(22, 13);
//    }
//
//    @Test
//    public void queryTest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        FvbAddedRestaurantMapper fvbAddedRestaurantMapper = context.getBean(FvbAddedRestaurantMapper.class);
//        List<FvbRestaurant> list = fvbAddedRestaurantMapper.queryAddedRestaurantsByUserId(22);
//        for (FvbRestaurant res : list) {
//            System.out.println(res.toString());
//        }
//
//    }

//    @Test
//    public void queryTest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        FvbAddedRestaurantMapper fvbAddedRestaurantMapper = context.getBean(FvbAddedRestaurantMapper.class);
//        FvbRestaurant restaurant = fvbAddedRestaurantMapper.queryRestaurantsByNameCityAddress("kfccc", "nyc", "11");
//        System.out.println(restaurant.toString());
//    }
//    @Test
//    public void queryTest2() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        FvbAddedRestaurantMapper fvbAddedRestaurantMapper = context.getBean(FvbAddedRestaurantMapper.class);
//        FvbRestaurant restaurant = fvbAddedRestaurantMapper.queryAddedRestaurant(22, 13);
//        System.out.println(restaurant.toString());
//    }
}
