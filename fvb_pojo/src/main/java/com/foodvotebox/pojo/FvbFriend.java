package com.foodvotebox.pojo;

import java.io.Serializable;

/**
 * Created by wuqi on 6/23/17.
 */

public class FvbFriend implements Serializable{

    private Long friendid;

    private String friend_name;

    public Long getFriendid() {
        return friendid;
    }

    public void setFriendid(Long friendid) {
        this.friendid = friendid;
    }

    public String getFriendname() {
        return friend_name;
    }

    public void setFriendname(String friendname) {
        this.friend_name = friendname;
    }

    @Override
    public String toString() {
        return "FvbFriend [id=" + friendid + ", friendname=" + friend_name +  "]";
    }

}
