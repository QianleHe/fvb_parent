package com.foodvotebox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by qianle on 7/2/17.
 */
@Controller
@RequestMapping("/")
public class LocationController {
//    @Autowired
//    public


    @RequestMapping("/getlocation")
    public void getLocation(HttpServletRequest request, HttpSession session) {
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        Double[] location = new Double[2];
        location[0] = latitude;
        location[1] = longitude;
        session.setAttribute("locationnow", location);
    }
}
