package com.foodvotebox.pojo;

/**
 * Created by FYG on 17/6/25.
 */
public class FvbRestaurant {
    Long restaurantId;

    String restaurantName;

    String address;

    String phone;

    String photoDir;

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

    public String getPhotoDir() {
        return photoDir;
    }

    public void setPhotoDir(String photoDir) {
        this.photoDir = photoDir;
    }

    @Override
    public String toString() {
        return "FvbRestaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", photoDir='" + photoDir + '\'' +
                '}';
    }
}
