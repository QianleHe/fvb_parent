package com.foodvotebox.serviceTest;

import com.foodvotebox.mapper.FvbEventMemberMapper;
import com.foodvotebox.mapper.FvbEventRestaurantMapper;
import com.foodvotebox.mapper.FvbRestaurantMapper;
import com.foodvotebox.pojo.FvbEventMember;
import com.foodvotebox.pojo.FvbRestaurant;
import com.foodvotebox.service.EventService;
import com.foodvotebox.service.RestaurantService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by FYG on 17/6/25.
 */

public class EventServiceTest {
//    @Autowired
//    public FvbEventRestaurantMapper mapper;
//    @Autowired
//    @Qualifier(value = "restaurantService")
//    public RestaurantService restaurantService;
//    @Test
//    public void testInsert(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
//        RestaurantService restaurantService = (RestaurantService) context.getBean(RestaurantService.class);
//        Long result = restaurantService.insertRestaurant("name","city", "add", "phone", "price", null , null , null);
//        System.out.println(result);
//    }

    //    @Autowired
//    public FvbEventRestaurantMapper mapper;
//
//    @Test
//    public void testInsert() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        FvbEventRestaurantMapper mapper = (FvbEventRestaurantMapper) context.getBean(FvbEventRestaurantMapper.class);
//        mapper.insertRestaurant((long)26, (long)1);
//    }

//    @Test
//    public void testFind() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        FvbEventMemberMapper mapper = (FvbEventMemberMapper) context.getBean(FvbEventMemberMapper.class);
//        List<FvbEventMember> result = mapper.findAllMembers((long)31);
//        for (int i = 0; i < result.size(); i++) {
//            FvbEventMember a = (FvbEventMember)result.get(i);
//            System.out.println(a.getMemberId());
//        }
//
//    }

}
