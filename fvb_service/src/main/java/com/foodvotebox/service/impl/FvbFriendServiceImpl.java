package com.foodvotebox.service.impl;

import com.foodvotebox.mapper.FvbFriendMapper;
import com.foodvotebox.mapper.FvbUserMapper;
import com.foodvotebox.pojo.FvbFriend;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.FvbFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuqi on 6/23/17.
 */
@Service(value = "friendService")
public class FvbFriendServiceImpl implements FvbFriendService {
    @Autowired(required = false)
    private FvbFriendMapper fvbFriendMapper;
    @Autowired(required = false)
    private FvbUserMapper fvbUserMapper;

    @Override
    public void addFriend(long userId, long friendId, String friendName) {
        fvbFriendMapper.addFriend(userId, friendId, friendName);
    }
    @Override
    public void addFriend(long userId, String friendName){
        FvbUser friend = fvbUserMapper.queryByUserName(friendName);
        if (friend != null){
            fvbFriendMapper.addFriend(userId,friend.getUserId(),friendName);
        }
    }
    @Override
    public void deleteFriend(long userId, long friendId) {
        fvbFriendMapper.deleteFriend(userId, friendId);
    }

    @Override
    public boolean deleteFriend(long userId, String friendName) {
        FvbUser friend = fvbUserMapper.queryByUserName(friendName);
        if (friend != null){
            fvbFriendMapper.deleteFriend(userId, friend.getUserId());
            return true;
        }
        return false;
    }


    @Override
    public boolean cannotAddFriend(long userId, String friendName) {
        //FIXME: WHEN CANNOT FIND FRIEND, IT IS SET TO TRUE.
        FvbUser friend = fvbUserMapper.queryByUserName(friendName);
        return friend == null ||fvbFriendMapper.queryFriendById(userId,friend.getUserId()) != null;
    }

    @Override
    public List<FvbFriend> displayFriend(long userId) {
        return fvbFriendMapper.queryById(userId);
    }

}
