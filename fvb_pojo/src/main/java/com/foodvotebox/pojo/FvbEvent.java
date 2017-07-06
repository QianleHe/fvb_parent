package com.foodvotebox.pojo;

import java.util.Date;

/**
 * Created by FYG on 17/6/22.
 */
public class FvbEvent {
    private Long eventId;

    private String eventName;

    private String eventDate;

    private Long ownerId;

    private String description;

    private Long resultid;

    private boolean submitted;


    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEventId() {

        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getDescription() {
        return description;
    }


    public Long getResultid() {
        return resultid;
    }

    public void setResultid(Long resultid) {
        this.resultid = resultid;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    @Override
    public String toString() {
        return "FvbEvent{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", ownerId=" + ownerId +
                ", description='" + description + '\'' +
                ", resultid=" + resultid +
                ", submitted=" + submitted +
                '}';
    }
}
