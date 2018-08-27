package com.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/")
public class TestController {

    @Reference(version = "1.0.0")
    @Resource
    private UserService userService;


    @GetMapping("getUser")
    public User getUserById() {
        return userService.getUserById(1L);
    }

    @GetMapping("sendMsg")
    public String sendMsg() {
        return userService.sendMsg(1L);
    }

    @GetMapping("validCode")
    public boolean validCode() {
        Long userId = 1L;
        return userService.validCode(userId);
    }

}
