package com.fancv.dubbo.order.service;

import com.fancv.dubbo.api.service.TestService;

public class MockServiceImpl implements TestService {
    @Override
    public String showName() {
        return "this is consumer mock";
    }
}
