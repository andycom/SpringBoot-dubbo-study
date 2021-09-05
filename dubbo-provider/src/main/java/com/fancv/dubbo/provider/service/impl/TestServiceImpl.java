package com.fancv.dubbo.provider.service.impl;

import com.fancv.dubbo.api.service.TestService;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService(version = "1.0.0")
public class TestServiceImpl implements TestService {
    @Override
    public String showName() {
        return "HELLO   DUBBO";
    }
}
