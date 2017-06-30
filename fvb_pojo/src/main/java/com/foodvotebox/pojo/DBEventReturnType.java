package com.foodvotebox.pojo;



/**
 * Created by FYG on 17/6/29.
 */
public class DBEventReturnType {
    private Long eventId;

    private Long memberId;

    private boolean voted;

    private String eventName;

    private String eventDate;

    private Long ownerId;

    private String userName;

    private String description;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }


    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "DBEventReturnType{" +
                "eventId=" + eventId +
                ", memberId=" + memberId +
                ", voted=" + voted +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", ownerId=" + ownerId +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
