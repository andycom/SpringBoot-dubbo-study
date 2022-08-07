package com.fancv.dubbo.order.service;

import com.fancv.dubbo.api.service.TestService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MockServiceImpl2 implements TestService2 {
    @Override
    public String showName() {

        log.info("Consumer mock");
        return null;
    }
}
