package com.foodvotebox.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qianle on 7/5/17.
 */


public class FvbMessage implements Serializable{

    private int msgId;
    private Long fromId;
    private Long toId;
    private String content;
    private Date createdDate;
    private int hasRead;
    private String conversationId;

    public int getId() {
        return msgId;
    }

    public void setId(int id) {
        this.msgId = id;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getHasRead() {
        return hasRead;
    }

    public void setHasRead(int hasRead) {
        this.hasRead = hasRead;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public void setConversationId(Long fromId, Long toId){
        this.conversationId = String.format("%d_%d", Math.min(fromId, toId), Math.max(fromId, toId));
    }

    @Override
    public String toString() {
        return "FvbMessage{" +
                "msgId=" + msgId +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", hasRead=" + hasRead +
                ", conversationId='" + conversationId + '\'' +
                '}';
    }
}
