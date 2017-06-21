package com.FoodVoteBox.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by qianle on 6/17/17.
 */
public class PasswordChecker {
    public boolean checkerPassword(String newPassword, String oldPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        PasswordEncoder encoder = new PasswordEncoder();
        if (encoder.EncoderByMd5(newPassword).equals(oldPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
