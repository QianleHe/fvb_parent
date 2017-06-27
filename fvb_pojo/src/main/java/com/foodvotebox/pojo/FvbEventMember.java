package com.foodvotebox.pojo;

/**
 * Created by FYG on 17/6/25.
 */
public class FvbEventMember {
    Long eventid;

    Long memberId;

    boolean voted;

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
        return "FvbEventMember{" +
                "eventid=" + eventid +
                ", memberId=" + memberId +
                ", voted=" + voted +
                '}';
    }
}
