package com.foodvotebox.mapper;

import com.foodvotebox.pojo.DBEventMemberReturnType;
import com.foodvotebox.pojo.FvbEventMember;
import com.foodvotebox.pojo.FvbEventRestaurant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by FYG on 17/6/25.
 */
public interface FvbEventMemberMapper {
    void insertMember(@Param("eventId") Long eventId, @Param("memberId") Long memberId);

    FvbEventMember findEventMember(@Param("eventId") Long eventId, @Param("memberId") Long memberId);

    List<DBEventMemberReturnType> findAllMembers(@Param("eventId") Long eventId);

    void deleteEventMember(@Param("eventId") Long eventId, @Param("memberId") Long memberId);

    DBEventMemberReturnType getEventMember(@Param("userId") Long userId, @Param("eventId") Long eventId);

    void updateVoteStatus(@Param("eventId") Long eventId, @Param("memberId") Long memberId);
}
