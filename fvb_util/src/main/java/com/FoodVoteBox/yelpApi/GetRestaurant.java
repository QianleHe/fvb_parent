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
    /*
    *   term: Optional. Search term (e.g. "food", "restaurants"). If term isn’t included we search everything.
    *         The term keyword also accepts business names such as "Starbucks".
    *
    *   location: Required if either latitude or longitude is not provided.
    *         Specifies the combination of "address, neighborhood, city, state or zip, optional country" to be used when searching for businesses.
    *
    *   latitude and longitude: optional. (latitude, longitude) and location must have one when you start a search.
    *
    *   redis: Optional. Search radius in meters. If the value is too large, a AREA_TOO_LARGE error may be returned. The max value is 40000 meters (25 miles)
    *
    *   categories: Optional. check https://www.yelp.com/developers/documentation/v2/all_category_list to take look at what categories are
    *
    *   limit: Optional. Number of business results to return. By default, it will return 20. Maximum is 50.
    *
    *   offset: Optional. Offset the list of returned business results by this amount.
    *
    *   sort_by: Optional. Sort the results by one of the these modes: best_match, rating, review_count or distance.
    *           By default it's best_match. The rating sort is not strictly sorted by the rating value,
    *           but by an adjusted rating value that takes into account the number of ratings, similar to a bayesian average.
    *
    *   price: Optional. Pricing levels to filter the search result with: 1 = $, 2 = $$, 3 = $$$, 4 = $$$$.
    *          The price filter can be a list of comma delimited pricing levels. For example, "1, 2, 3" will filter the results to show the ones that are $, $$, or $$$.
    *
    *   open_now: Optional. Default to false. When set to true, only return the businesses open now. Notice that open_at and open_now cannot be used together.
    *
    *   attributes: Optional. Additional filters to restrict search results. Possible values are:
    *               1. hot_and_new - Hot and New businesses
    *               2. request_a_quote - Businesses that have the Request a Quote feature
    *               3. waitlist_reservation - Businesses that have an online waitlist
    *               4. cashback - Businesses that offer Cash Back
    *               5. deals - Businesses that offer Deals
    *               6. gender_neutral_restrooms - Businesses that provide gender neutral restrooms
    *
    * */
    public JSONObject getRes(String term, String location, Double latitude, Double longitude, Integer redis, String categories, Integer limit, Integer offset, String sort_by, String price, Boolean open_now, String attributes) {
        Token token = new Token();
        String accessToken = token.getToken();
        OkHttpClient client2 = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + location +
                        "&latitude=" + latitude + "&longitude=" + longitude + "&redis=" + redis +
                        "&categories=" + categories + "&limit=" + limit + "&offset=" + offset + "&sort_by=" + sort_by
                        + "&price=" + price + "&open_now" + open_now + "&attributes" + attributes)
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
