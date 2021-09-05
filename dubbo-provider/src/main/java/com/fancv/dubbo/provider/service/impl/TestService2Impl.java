package com.fancv.dubbo.provider.service.impl;

import com.fancv.dubbo.api.service.TestService2;
import org.apache.dubbo.config.annotation.DubboService;

/**
 *
 */
@DubboService(version = "1.0.0")
public class TestService2Impl implements TestService2 {
    @Override
    public String showName() {
        return "HELLO   TestService2";
    }
}
