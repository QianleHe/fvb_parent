package com.foodvotebox.service.impl;

import com.FoodVoteBox.exception.MessageStatusEnum;
import com.foodvotebox.mapper.FvbMessageMapper;
import com.foodvotebox.pojo.FvbMessage;
import com.foodvotebox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qianle on 7/5/17.
 */
@Service
public class MessageServiceImpl  implements MessageService{

    @Autowired(required = false)
    public FvbMessageMapper fvbMessageMapper;

    @Override
    public MessageStatusEnum addMessage(FvbMessage message) {
        if (message == null) return MessageStatusEnum.NULL_MESSAGE;
        fvbMessageMapper.addMessage(message);
        return MessageStatusEnum.SEND_SUCCESS;
    }

    @Override
    public List<FvbMessage> getLatestMessages(String conversationId, int offset, int limit) {
        return fvbMessageMapper.getLastestMessages(conversationId, offset, limit);
    }

    @Override
    public List<FvbMessage> getMessageList(long userId, int offset, int limit) {
        return fvbMessageMapper.getMessageList(userId, offset, limit);
    }

    @Override
    public MessageStatusEnum updateHasRead(long msgId, long userId) {
        fvbMessageMapper.updateHasRead(msgId, 1, userId);
        return MessageStatusEnum.UPDATE_SUCCESS;
    }

    @Override
    public int getUnreadMessages(long userId) {
        return fvbMessageMapper.getConversationUnreadMsgs(userId);
    }

    @Override
    public MessageStatusEnum deleteMessage(long msgId) {
        fvbMessageMapper.daleteMessage(msgId);
        FvbMessage fvbMessage = fvbMessageMapper.queryMessageById(msgId);
        if (fvbMessage != null) return MessageStatusEnum.UPDATE_ERROR;
        return MessageStatusEnum.DELETE_SUCCESS;
    }

    @Override
    public List<FvbMessage> getAllMessagesReceived(long userId, int offset, int limit) {
        return fvbMessageMapper.getAllMessagesReceived(userId, offset, limit);
    }

    @Override
    public List<FvbMessage> getAllMessagesSent(long userId, int offset, int limit) {
        return fvbMessageMapper.getAllMessagesSent(userId, offset, limit);
    }

    @Override
    public List<FvbMessage> getAllMessagesUnread(long userId, int offset, int limit) {
        return fvbMessageMapper.getAllMessageUnread(userId, offset, limit);
    }
}
