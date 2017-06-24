package com.foodvotebox.service.impl;

import com.foodvotebox.mapper.FvbFriendMapper;
import com.foodvotebox.pojo.FvbFriend;
import com.foodvotebox.service.FvbFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by wuqi on 6/23/17.
 */
public class FvbFriendServiceImpl implements FvbFriendService {
    @Autowired
    private FvbFriendMapper fvbFriendMapper;

    @Override
    public void addFriend(long userId, long friendId, String friendName) {
        fvbFriendMapper.addFriend(userId, friendId, friendName);
    }

    @Override
    public void deleteFriend(long userId, long friendId) {
        fvbFriendMapper.deleteFriend(userId, friendId);
    }

    @Override
    public List<FvbFriend> displayFriend(long userId) {
        return fvbFriendMapper.queryById(userId);
    }

}
