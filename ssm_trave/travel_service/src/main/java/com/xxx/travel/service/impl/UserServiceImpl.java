package com.xxx.travel.service.impl;

import com.xxx.travel.domain.Role;
import com.xxx.travel.domain.UserInfo;
import com.xxx.travel.mapper.RoleMapper;
import com.xxx.travel.mapper.UserMapper;
import com.xxx.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserInfo userInfo = null;
            try {
                //从数据库查询用户通过用户名
                userInfo = userMapper.findByUserName(userName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //封装spring提供的User类，四个布尔值都为true才能登陆，getAuthority需要一个角色集合
            //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
            User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(),
                    userInfo.getStatus() == 1?true:false,
                    true, true, true,
                    getAuthority(userInfo.getRoles()));
        //List<Role> roles = userInfo.getRoles();
        return user;
        }

        //作用就是返回一个List集合，集合中装入的是角色描述
        private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
            List<SimpleGrantedAuthority> list = new ArrayList<>();
            for (Role role : roles) {
                list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            }
            return list;
        }

}
