package com.foodvotebox.timer;

import com.foodvotebox.pojo.DBEventMemberReturnType;
import com.foodvotebox.pojo.FvbEvent;
import com.foodvotebox.pojo.FvbEventRestaurant;
import com.foodvotebox.pojo.FvbMessage;
import com.foodvotebox.service.EventService;
import com.foodvotebox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;


/**
 * Created by qianle on 7/6/17.
 */
@Component
public class TimerTask {

    @Autowired
    @Qualifier(value = "eventService")
    public EventService eventService;

    @Autowired
    public MessageService messageService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void task1() {
        List<FvbEvent> events = eventService.getFinishedEventByEndTime();
        for (FvbEvent event : events) {
            List<FvbEventRestaurant> resultList = eventService.getEventVotes(event.getEventId());
            if (resultList != null && resultList.size() != 0) {
                if (resultList.size() == 1) {
                    eventService.updateEventResult(event.getEventId(), resultList.get(0).getRestaurantId());
                } else {
                    Long resultId = getResultId(resultList);
                    eventService.updateEventResult(event.getEventId(), resultId);
                }
                for (DBEventMemberReturnType user : eventService.findAllMembers(event.getEventId())) {
                    FvbMessage message = new FvbMessage();
                    message.setContent("");
                    message.setFromId((long) 22);
                    message.setToId(user.getMemberId());
                    messageService.addMessage(message);
                }
            } else {
                eventService.deleteEvent(event.getEventId());
            }
        }
    }

    public Long getResultId(List<FvbEventRestaurant> resultList) {
        Random rand = new Random();
        int resultNum = rand.nextInt(resultList.size());
        return resultList.get(resultNum).getRestaurantId();
    }
}
