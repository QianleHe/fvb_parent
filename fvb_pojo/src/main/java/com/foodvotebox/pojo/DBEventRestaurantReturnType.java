package com.foodvotebox.pojo;

import java.util.Date;

/**
 * Created by FYG on 17/7/3.
 */
public class DBEventRestaurantReturnType {
    private Long restaurantId;

    private String restaurantName;

    private String city;

    private String address;

    private String phone;

    private String price;

    private String rating;

    private String yelpUrl;

    private String imgUrl;


    private int votes;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYelpUrl() {
        return yelpUrl;
    }

    public void setYelpUrl(String yelpUrl) {
        this.yelpUrl = yelpUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "DBEventRestaurantReturnType{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", price='" + price + '\'' +
                ", rating='" + rating + '\'' +
                ", yelpUrl='" + yelpUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", votes=" + votes +
                '}';
    }
}
