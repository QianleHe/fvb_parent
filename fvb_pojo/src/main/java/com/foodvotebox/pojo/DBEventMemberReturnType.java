package com.foodvotebox.pojo;

import java.io.Serializable;

/**
 * Created by FYG on 17/6/27.
 */
public class DBEventMemberReturnType implements Serializable {
    Long eventid;

    Long memberId;

    boolean voted;

    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String memberName) {
        this.userName = memberName;
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    @Override
    public String toString() {
        return "DBEventMemberReturnType{" +
                "eventid=" + eventid +
                ", memberId=" + memberId +
                ", voted=" + voted +
                ", userName='" + userName + '\'' +
                '}';
    }
}
