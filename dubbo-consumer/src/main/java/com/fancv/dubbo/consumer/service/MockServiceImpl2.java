package com.fancv.dubbo.consumer.service;

import com.fancv.dubbo.api.service.TestService2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockServiceImpl2 implements TestService2 {
    @Override
    public String showName() {

        log.info("Consumer mock");
        return null;
    }
}
