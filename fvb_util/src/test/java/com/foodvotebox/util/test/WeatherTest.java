package com.foodvotebox.util.test;

import com.FoodVoteBox.weatherApi.GetWeather;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by qianle on 7/2/17.
 */
public class WeatherTest {


    @Test
    public void testWeather() {
        GetWeather getWeather = new GetWeather();
        JSONObject object = getWeather.getWeather(47.6638866,-122.31430569999999);
        System.out.println(object.toString());
    }
}
