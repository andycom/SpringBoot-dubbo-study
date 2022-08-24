package com.fancv.tcc.card.service;


import com.fancv.dubbo.api.card.CardService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0",timeout = 5000)
public class CardServiceImpl implements CardService {

    @Override
    public String record(int num) {
        return "OK";
    }
}
