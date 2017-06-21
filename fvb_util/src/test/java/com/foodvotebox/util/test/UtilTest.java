package com.foodvotebox.util.test;

import com.FoodVoteBox.util.PasswordChecker;
import com.FoodVoteBox.util.PasswordEncoder;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by qianle on 6/19/17.
 */
public class UtilTest {

    @Test
    public void testChecker() {
        PasswordChecker checker = new PasswordChecker();
        PasswordEncoder encoder = new PasswordEncoder();
        try {
            String s = encoder.EncoderByMd5("123456");
            System.out.println(s);
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        try {
            boolean is = checker.checkerPassword("123456", "4QrcOUm6Wau+VuBX8g+IPg==");
            System.out.println(is);
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }

    }

}
