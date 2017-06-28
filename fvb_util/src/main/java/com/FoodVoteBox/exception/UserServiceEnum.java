package com.FoodVoteBox.exception;

/**
 * Created by qianle on 6/24/17.
 */
public enum UserServiceEnum {
    // sign up part
    SIGNUP_SUCCESS(0, "Signup Success"),
    REPEAT_EMAIL(1, "This Email has been registed"),
    REPEAT_USERNAME(2, "This Username has been registed"),
    // login part
    NOSUCH_ACCOUNT(3, "no such account"),
    PASSWORD_ERROR(4, "Wrong password"),
    SIGNIN_SUCCESS(5, "Login Success"),
    INNER_ERROR(-1, "Unknown Error");

    private int state;

    private String stateinfo;

    private UserServiceEnum(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }

    public int getState() {
        return state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    public static UserServiceEnum indexOf(int index) {
        for (UserServiceEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
