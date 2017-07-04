package com.FoodVoteBox.exception;

/**
 * Created by qianle on 7/3/17.
 */
public enum AddAsFavouriteEnum {
    ADD_SUCCESS(1, "ADDED SUCCESSFULLY"),
    ALREADY_ADDED(2, "THIS ONE HAS ALREADY ADDED"),
    NOSUCH_RESTAURANT(3, "There is no such restaurant in your favourite list"),
    REMOVE_SUCCESS(4, "REMOVED SUCCESSED"),
    UNKNOWN_ERROR(-1, "UNKNOW ERROR");

    int state;

    String stateinfo;

    AddAsFavouriteEnum(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }

    public int getState() {
        return state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

}
