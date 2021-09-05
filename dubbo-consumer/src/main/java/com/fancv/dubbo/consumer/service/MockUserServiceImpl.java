package com.fancv.dubbo.consumer.service;

import com.fancv.dubbo.api.BO.User;
import com.fancv.dubbo.api.service.UserService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MockUserServiceImpl implements UserService {
    @Override
    public User getUserInfo(String name) {

        log.error("远程服务异常，启用mock");

        User result = User.builder().name("MOCK OB" +
                "ject").address("dd").build();
        return result;
    }
}
