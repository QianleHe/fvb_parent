package com.foodvotebox.service;

/**
 * Created by qianle on 6/17/17.
 */
public interface LoginService {
    public boolean login(String email, String username, String password);

    public void register(String userName, String password, String email, String phone);
}
