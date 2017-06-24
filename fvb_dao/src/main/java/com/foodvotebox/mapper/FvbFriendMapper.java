package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbFriend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuqi on 6/23/17.
 */
public interface FvbFriendMapper {
    void addFriend(@Param("userId") long userId, @Param("friendId") long friendId, @Param("friendName") String friendName);

    void deleteFriend(@Param("userId") long userId, @Param("friendId") long friendId);

    List<FvbFriend> queryById(long userId);

}
