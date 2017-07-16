package com.foodvotebox.controller;

import com.FoodVoteBox.yelpApi.GetRestaurant;
import com.foodvotebox.pojo.YelpQueryPojo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    @RequestMapping(value = "/listAllRestaurants")
    @ResponseBody
    public String getAllRes(YelpQueryPojo yelpQueryPojo, HttpSession session) {
        // location must has one
        if (yelpQueryPojo.getTerm() == null) {
            yelpQueryPojo.setTerm("");
        }
        if (yelpQueryPojo.getLocation() == null && (yelpQueryPojo.getLatitude() == null && yelpQueryPojo.getLongitude() == null)) {
            Double[] location = (Double[])session.getAttribute("locationnow");
            if (location != null) {
                yelpQueryPojo.setLatitude(location[0]);
                yelpQueryPojo.setLongitude(location[1]);
            } else {
                yelpQueryPojo.setLocation("Seattle");
                yelpQueryPojo.setLatitude(0.0);
                yelpQueryPojo.setLongitude(0.0);
            }
        }
        if (yelpQueryPojo.getRedis() == null) {
            yelpQueryPojo.setRedis(2000);
        }
        if (yelpQueryPojo.getSort_by() == null) {
            yelpQueryPojo.setSort_by("best_match");
        }
        if (yelpQueryPojo.getCategories() == null) {
            yelpQueryPojo.setCategories("food");
        }
        if (yelpQueryPojo.getLimit() == null) {
            yelpQueryPojo.setLimit(40);
        }
        yelpQueryPojo.setOffset(0);
        if (yelpQueryPojo.getPrice() == null) {
            yelpQueryPojo.setPrice("1,2,3,4");
        }
        if (yelpQueryPojo.getOpen_now() == null) {
            yelpQueryPojo.setOpen_now(false);
        }
        if (yelpQueryPojo.getAttributes() == null) {
            yelpQueryPojo.setAttributes("default");
        }
        JSONObject object = getRestaurant.getRes(yelpQueryPojo.getTerm(), yelpQueryPojo.getLocation(), yelpQueryPojo.getLatitude(), yelpQueryPojo.getLongitude(),
                yelpQueryPojo.getRedis(), yelpQueryPojo.getCategories(), yelpQueryPojo.getLimit(), yelpQueryPojo.getOffset(), yelpQueryPojo.getSort_by(), yelpQueryPojo.getPrice(),
                yelpQueryPojo.getOpen_now(), yelpQueryPojo.getAttributes());
        String Json = object.toString();
        return Json;
    }
}
