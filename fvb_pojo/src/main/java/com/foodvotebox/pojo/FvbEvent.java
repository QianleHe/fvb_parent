package com.foodvotebox.pojo;

import java.util.Date;

/**
 * Created by FYG on 17/6/22.
 */
public class FvbEvent {
    private Long eventid;

    private String eventname;

    private String eventdate;

    private Long ownerid;



    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public Long getEventid() {

        return eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public String getEventdate() {
        return eventdate;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    @Override
    public String toString() {
        return "FvbEvent{" +
                "eventid=" + eventid +
                ", eventname='" + eventname + '\'' +
                ", eventdate=" + eventdate +
                ", ownerid=" + ownerid +
                '}';
    }
}
