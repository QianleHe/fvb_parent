package com.FoodVoteBox.exception;

/**
 * Created by qianle on 7/5/17.
 */
public enum MessageStatusEnum {

    UNKOWN_ERROR(-1, "Unknown error"),
    CANNOT_SEND(-2, "this message cannot be send"),
    NULL_MESSAGE(-3, "this message cannot be null"),
    UPDATE_ERROR(-4, "update fail"),
    SEND_SUCCESS(1, "Send success"),
    UPDATE_SUCCESS(2, "updated success"),
    DELETE_SUCCESS(3, "delete success");

    int state;

    String stateinfo;

    MessageStatusEnum(int state, String stateinfo) {
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
