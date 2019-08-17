package com.xxx.travel.mapper;

import com.xxx.travel.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from users where id=#{id}")
    public UserInfo findUserById(Long id);

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.xxx.travel.mapper.RoleMapper.findRoleById"))
    })
    public UserInfo findByUserName(String userName) throws Exception;
}
