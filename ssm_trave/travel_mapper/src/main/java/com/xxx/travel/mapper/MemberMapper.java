package com.xxx.travel.mapper;

import com.xxx.travel.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    @Select("select * from member where id=#{id}")
    public Member findMemberById(String id) throws Exception;
}
