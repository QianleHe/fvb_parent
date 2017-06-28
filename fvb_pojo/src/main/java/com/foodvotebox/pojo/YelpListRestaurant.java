package com.foodvotebox.pojo;

/**
 * Created by qianle on 6/27/17.
 */
public class YelpListRestaurant {

    public String name;
    public String phoneNumber;
    public String price;
    public String displayAddress;
    public String urlOnYelp;
    public String rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(String displayAddress) {
        this.displayAddress = displayAddress;
    }

    public String getUrlOnYelp() {
        return urlOnYelp;
    }

    public void setUrlOnYelp(String urlOnYelp) {
        this.urlOnYelp = urlOnYelp;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }


    @Override
    public String toString() {
        return "YelpListRestaurant{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", price='" + price + '\'' +
                ", displayAddress='" + displayAddress + '\'' +
                ", urlOnYelp='" + urlOnYelp + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
