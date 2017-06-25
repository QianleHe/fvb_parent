package com.foodvotebox.service;

import com.FoodVoteBox.exception.UserServiceEnum;

/**
 * Created by qianle on 6/17/17.
 */
public interface LoginService {
    UserServiceEnum login(String email, String username, String password);

    void register(String userName, String password, String email, String phone);
}
