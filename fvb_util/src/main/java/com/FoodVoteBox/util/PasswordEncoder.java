package com.FoodVoteBox.util;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/**
 * Created by qianle on 6/17/17.
 */
@Component
public class PasswordEncoder {
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // get the salt value which is from properties file
        //InputStream in = ClassLoader.getSystemResourceAsStream("properties/salt.properties");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("properties/salt.properties");
        System.out.println(in.toString() + "Wassup!! man");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
        }
        String salt = prop.getProperty("salt");

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        newstr += salt;
        return newstr;
    }

}
