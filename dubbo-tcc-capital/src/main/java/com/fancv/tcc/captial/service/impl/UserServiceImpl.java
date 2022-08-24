package com.fancv.tcc.captial.service.impl;

import com.fancv.dubbo.api.BO.User;
import com.fancv.dubbo.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {


    @Override
    public User getUserInfo(String name) {
        log.info("查询用户数据入参：{}",name);
        return User.builder().address("BJ").name("复兴中华").build();
    }
}
