package com.foodvotebox.service;

import com.FoodVoteBox.exception.MessageStatusEnum;
import com.foodvotebox.pojo.FvbMessage;

import java.util.List;

/**
 * Created by qianle on 7/5/17.
 */
public interface MessageService {

    MessageStatusEnum addMessage(FvbMessage message);

    List<FvbMessage> getLatestMessages(String conversationId, int offset, int limit);

    List<FvbMessage> getMessageList(long userId, int offset, int limit);

    MessageStatusEnum updateHasRead(long msgId, long userId);

    int getUnreadMessages(long userId);

    MessageStatusEnum deleteMessage(long msgId);

    List<FvbMessage> getAllMessagesReceived(long userId, int offset, int limit);

    List<FvbMessage> getAllMessagesSent(long userId, int offset, int limit);

    List<FvbMessage> getAllMessagesUnread(long userId, int offset, int limit);
}
