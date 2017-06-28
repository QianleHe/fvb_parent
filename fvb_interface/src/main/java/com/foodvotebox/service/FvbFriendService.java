package com.foodvotebox.service;

import com.foodvotebox.pojo.FvbFriend;

import java.util.List;

/**
 * Created by wuqi on 6/23/17.
 */
public interface FvbFriendService {
    public void addFriend(long userId, long friendId, String friendName);
    public void addFriend(long userId, String friendName);
    public void deleteFriend(long userId, long friendId);
    public boolean deleteFriend(long userId, String friendName);
    public boolean cannotAddFriend(long userId, String friendName);
    public List<FvbFriend> displayFriend(long userId);
}
