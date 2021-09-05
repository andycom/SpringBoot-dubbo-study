package com.fancv.dubbo.consumer;

import com.fancv.dubbo.api.BO.User;
import com.fancv.dubbo.api.service.TestService;
import com.fancv.dubbo.api.service.TestService2;
import com.fancv.dubbo.api.service.UserService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@Api(tags = "1.0")
@RequestMapping("1")
public class TestDubboController {
    @DubboReference(check = false, lazy = true, version = "1.0.0", mock = "com.fancv.dubbo.consumer.service.MockServiceImpl2")
    TestService2 service2;
    @DubboReference(check = false,version = "1.0.0", mock = "com.fancv.dubbo.consumer.service.MockServiceImpl")
    TestService service;
    @DubboReference(check = false,version = "1.0.0", mock = "com.fancv.dubbo.consumer.service.MockUserServiceImpl")
    UserService userService;

    @GetMapping("test1")
    public String test1() {
        return service.showName();
    }

    @GetMapping("test2")
    public String test2() {
        return service2.showName();
    }
    @GetMapping("user")
    public User getUserInfo(String name){
        return userService.getUserInfo(name);
    }
}
