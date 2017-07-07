package com.foodvotebox.pojo;

import java.io.Serializable;

/**
 * Created by FYG on 17/6/25.
 */
public class FvbEventRestaurant implements Serializable{
    Long eventId;

    Long restaurantId;

    int votes;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "FvbEventRestaurant{" +
                "eventId=" + eventId +
                ", restaurantId=" + restaurantId +
                ", votes=" + votes +
                '}';
    }
}
