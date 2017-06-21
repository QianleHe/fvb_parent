package com.foodvotebox.util.test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by qianle on 6/20/17.
 */
public class SaltTest {
    @Test
    public void testSalt() {
        InputStream in = ClassLoader.getSystemResourceAsStream("properties/salt.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
        }
        String salt = prop.getProperty("salt");
        System.out.println(salt);
    }
}
