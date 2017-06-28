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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by qianle on 6/26/17.
 */

@Controller
@RequestMapping("")
//@Configuration(value = "spring/ApplicationContext-dao.xml")
public class YelpRestaurantController {

    @Autowired
    @Qualifier(value = "getRestaurant")
    public GetRestaurant getRestaurant;

    Logger logger = Logger.getAnonymousLogger();

    @RequestMapping("/restaurant")
    public String getResList() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
        //GetRestaurant getRestaurant = context.getBean(GetRestaurant.class);
        //JSONObject object = getRestaurant.getRes("HOTPOT", "WA","1",1);
        //System.out.println(object.toString());
        return "listRestaurant";
    }

    @RequestMapping(value = "/listRestaurant")
    @ResponseBody
    public String getResListByLocation(HttpServletRequest request, Map<String, String> model) {
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        System.out.println(latitude + "--------" + longitude);
        JSONObject object = getRestaurant.getResByLocation(latitude, longitude, 1);
        logger.log(Level.INFO, object.toString());
        model.put("errorInfo", object.toString());
        String resInfo = object.toString();
        return resInfo;
    }
}
