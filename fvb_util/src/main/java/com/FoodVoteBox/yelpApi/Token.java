package com.FoodVoteBox.yelpApi;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by qianle on 6/25/17.
 */
public class Token {
    public String getToken() {
        // POST https://api.yelp.com/oauth2/token
        String accessToken=null;

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_id=ghRwENzjazf5b94m5ga5NQ&client_secret=akoEHpDeKfgIK9AXsA6OE5M0azL8LqaVsrM5D4nVL7bVcpWHNTzENURzVbGFIFXk&grant_type=client_credentials");
        Request request = new Request.Builder()
                .url("https://api.yelp.com/oauth2/token")
                .post(body)
                //.addHeader("cache-control", "no-cache")
                //.addHeader("postman-token", "8d9de8ad-800c-50e1-fb4a-46fcb5f2f209")
                //.addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        try {
            Response response = client.newCall(request).execute();

            JSONObject jsonObjectToken = new JSONObject(response.body().string().trim());

            accessToken = jsonObjectToken.getString("access_token");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return accessToken;
    }

}
