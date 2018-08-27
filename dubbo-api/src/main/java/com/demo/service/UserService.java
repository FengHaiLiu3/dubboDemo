package com.demo.service;

import com.demo.entity.User;

public interface UserService {
    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    User getUserById(Long userId);

    /**
     * 根据用户id，生成验证码
     *
     * @param userId
     * @return
     */
    String sendMsg(Long userId);

    /**
     * 根据用户id，校验验证码有效性
     *
     * @param userId
     * @return
     */
    boolean validCode(Long userId);
}
