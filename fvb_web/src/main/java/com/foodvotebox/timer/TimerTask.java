package com.foodvotebox.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by qianle on 7/6/17.
 */
@Component
public class TimerTask {

    @Autowired

    @Scheduled(cron = "0/10 * * * * ?")
    public void task1() {

        System.out.println("Hello");
    }
}
