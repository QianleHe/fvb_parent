package com.FoodVoteBox.yelpApi;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by qianle on 6/26/17.
 */
@Component
public class GetRestaurant {
    public JSONObject getRes(String term, String location, String price, Integer offset) {
        Token token = new Token();
        String accessToken = token.getToken();
        OkHttpClient client2 = new OkHttpClient();


        //String term = "KFC";                       // term
        //String location = "Irivine, CA";            // location
        //String price = "1";                         // price        1 = $, 2 = $$, 3 = $$$, 4 = $$$$


        Request request2 = new Request.Builder()
                .url("https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + location + "&limit=1&sort_by=rating&price="+price+"&offset="+offset+"")
                .get()
                .addHeader("authorization", "Bearer"+" "+accessToken)
                //.addHeader("cache-control", "no-cache")
                //.addHeader("postman-token", "b5fc33ce-3dad-86d7-6e2e-d67e14e8071b")
                .build();
        JSONObject jsonObject = null;
        try {
            Response response2 = client2.newCall(request2).execute();

            jsonObject = new JSONObject(response2.body().string().trim());       // parser
            JSONArray myResponse = (JSONArray)jsonObject.get("businesses");
            //System.out.println(myResponse.getJSONObject(0).getString("id"));
            //System.out.println(jsonObject.toString());


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject getResByLocation(Double latitude, Double longitude, int offset) {
        Token token = new Token();
        String accessToken = token.getToken();
        OkHttpClient client2 = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.yelp.com/v3/businesses/search?term=food" + "&latitude=" + latitude + "&longitude=" + longitude + "&offset=" + offset + "&limit=1" + "")
                .get()
                .addHeader("authorization", "Bearer"+" "+accessToken)
                //.addHeader("cache-control", "no-cache")
                //.addHeader("postman-token", "b5fc33ce-3dad-86d7-6e2e-d67e14e8071b")
                .build();

        JSONObject jsonObject = null;
        try {
            Response response2 = client2.newCall(request).execute();

            jsonObject = new JSONObject(response2.body().string().trim());       // parser
            //JSONArray myResponse = (JSONArray)jsonObject.get("businesses");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }
}
