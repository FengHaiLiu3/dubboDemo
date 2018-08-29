package com.demo.service.impl;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import com.demo.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@EnableCaching
@Service("userService")
public class UserSericeImpl implements UserService {
    private final StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserMapper userMapper;

    @Autowired
    public UserSericeImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectByUserId(userId);
    }

    @Transactional
    @Override
    public String sendMsg(Long userId) {
        User user = this.userMapper.selectByUserId(userId);
        if (null != user) {
            //TO-DO 调用短信借口发送短信
            String code = RandomUtil.randomCode();
            String key = Long.toString(userId);
            stringRedisTemplate.opsForValue().set(key, code, 60 * 10, TimeUnit.SECONDS);
            return code;

        }
        return "无此用户";
    }

    @Transactional
    @Override
    public boolean validCode(Long userId, String code) {
        sendMsg(userId);
        String key = Long.toString(userId);

        // do something
        return stringRedisTemplate.opsForValue().get(key).equals(code);

    }
}