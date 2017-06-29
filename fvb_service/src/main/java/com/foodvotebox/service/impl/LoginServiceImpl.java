package com.foodvotebox.service.impl;

import com.FoodVoteBox.exception.UserServiceEnum;
import com.FoodVoteBox.util.PasswordChecker;
import com.FoodVoteBox.util.PasswordEncoder;
import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by qianle on 6/17/17.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired(required = false)
    public FvbUserMapper fvbUserMapper;

    //@Autowired(required = false)
    //public PasswordChecker passwordChecker;

    public Logger logger = Logger.getAnonymousLogger();

    @Override
    public UserServiceEnum login(String email, String username, String password) {
        logger.log(Level.INFO, email);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
        PasswordChecker passwordChecker = (PasswordChecker)context.getBean("passwordChecker");
        FvbUser user;
        if (fvbUserMapper.queryByUserName(username) != null) {
            user = fvbUserMapper.queryByUserName(username);
        } else if (fvbUserMapper.queryByEmail(email) != null){
            user = fvbUserMapper.queryByEmail(email);
        } else {
            // there is no such user
            logger.log(Level.INFO, "NoSuchUser");
            return UserServiceEnum.NOSUCH_ACCOUNT;
        }

        logger.log(Level.INFO, user.toString());
        try {
            if (!passwordChecker.checkerPassword(password, user.getPassword())) {
                logger.log(Level.INFO, "Password wrong");
                return UserServiceEnum.PASSWORD_ERROR;
            }
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.INFO, e.toString());
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.INFO, e.toString());
        }
        return UserServiceEnum.SIGNIN_SUCCESS;
    }

    @Override
    public void register(String userName, String password, String phone, String email, String picid) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
        PasswordEncoder encoder = (PasswordEncoder)context.getBean("passwordEncoder");
        String newPassword = "";
        try {
            newPassword = encoder.EncoderByMd5(password);
            logger.log(Level.INFO, "----new password-----");
            logger.log(Level.INFO, newPassword);
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.INFO, e.toString());
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.INFO, e.toString());
        }
        logger.log(Level.INFO, userName);
        fvbUserMapper.addUser(userName, newPassword, phone, email, picid);
    }


}
