package com.foodvotebox.service;

/**
 * Created by qianle on 6/17/17.
 */
public interface LoginService {
    boolean login(String email, String username, String password);

    void register(String userName, String password, String email, String phone);
}
