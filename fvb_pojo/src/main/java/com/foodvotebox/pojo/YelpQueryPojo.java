package com.foodvotebox.pojo;

import java.io.Serializable;

/**
 * Created by qianle on 6/28/17.
 */
public class YelpQueryPojo implements Serializable{
    String term;
    String location;
    Double latitude;
    Double longitude;
    Integer redis;
    String categories;
    Integer limit;
    Integer offset;
    String sort_by;
    String price;
    Boolean open_now;
    String attributes;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getRedis() {
        return redis;
    }

    public void setRedis(Integer redis) {
        this.redis = redis;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSort_by() {
        return sort_by;
    }

    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getOpen_now() {
        return open_now;
    }

    public void setOpen_now(Boolean open_now) {
        this.open_now = open_now;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "YelpQueryPojo{" +
                "term='" + term + '\'' +
                ", location='" + location + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", redis=" + redis +
                ", categories='" + categories + '\'' +
                ", limit=" + limit +
                ", offset=" + offset +
                ", sort_by='" + sort_by + '\'' +
                ", price='" + price + '\'' +
                ", open_now=" + open_now +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}
