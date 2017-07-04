package com.FoodVoteBox.weatherApi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import sun.net.www.http.HttpClient;

import java.io.IOException;

/**
 * Created by qianle on 7/2/17.
 */

@Component
public class GetWeather {

    public JSONObject getWeather(Double latitude, Double longitude) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=6ad34d7083b90eb0487abb89ebd160fb")
                .build();
        JSONObject jsonObject = null;
        try {
            Response response2 = client.newCall(request).execute();

            jsonObject = new JSONObject(response2.body().string().trim());       // parser

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;


    }
}
