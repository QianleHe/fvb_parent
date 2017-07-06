package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qianle on 7/5/17.
 */
public interface FvbMessageMapper {

    public int addMessage(FvbMessage message);

    public List<FvbMessage> getLastestMessages(@Param("conversationId") String conversationId,
                                               @Param("offset") int offset,
                                               @Param("limit") int limit);

    public List<FvbMessage> getMessageList(@Param("userId") long userId,
                                        @Param("offset") int offset,
                                        @Param("limit") int limit);

    public int getConversationUnreadMsgs(@Param("userId") long userId);

    public void updateHasRead(@Param("msgId") long msgId,
                              @Param("hasRead") int hasRead,
                              @Param("userId") long userId);

    public void daleteMessage(@Param("msgId") long msgid);

    public FvbMessage queryMessageById(@Param("msgId") long msgId);

    public List<FvbMessage> getAllMessagesReceived(@Param("userId") long userId,
                                                   @Param("offset") int offset,
                                                   @Param("limit") int limit);

    public List<FvbMessage> getAllMessagesSent(@Param("userId") long userId,
                                               @Param("offset") int offset,
                                               @Param("limit") int limit);

    public List<FvbMessage> getAllMessageUnread(@Param("userId") long userId,
                                                @Param("offset") int offset,
                                                @Param("limit") int limit);
}
