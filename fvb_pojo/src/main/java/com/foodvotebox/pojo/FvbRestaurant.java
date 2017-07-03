package com.foodvotebox.pojo;

import java.util.Date;

/**
 * Created by FYG on 17/6/25.
 */
public class FvbRestaurant {
    private Long restaurantId;

    private String restaurantName;

    private String city;

    private String address;

    private String phone;

    private String rating;

    private String yelpUrl;

    private String imgUrl;

    private Date created;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "FvbRestaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rating='" + rating + '\'' +
                ", yelpUrl='" + yelpUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", created=" + created +
                '}';
    }
}
