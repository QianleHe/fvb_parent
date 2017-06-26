package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbEventMember;
import com.foodvotebox.pojo.FvbEventRestaurant;
import org.apache.ibatis.annotations.Param;

/**
 * Created by FYG on 17/6/25.
 */
public interface FvbEventMemberMapper {
    void insertMember(@Param("eventId") Long eventId, @Param("memberId") Long memberId);

    FvbEventMember findEventMember(@Param("eventId") Long eventId, @Param("memberId") Long memberId);
}
