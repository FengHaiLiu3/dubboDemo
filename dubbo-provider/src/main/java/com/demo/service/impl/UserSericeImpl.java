package com.demo.service.impl;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserSericeImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserById(int userId){
        return userMapper.selectByUserId(userId);
    }
}