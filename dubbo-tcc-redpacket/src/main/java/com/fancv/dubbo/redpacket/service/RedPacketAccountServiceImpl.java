package com.fancv.dubbo.redpacket.service;

import com.fancv.dubbo.api.redpacket.RedPacketAccountService;
import com.fancv.dubbo.redpacket.repository.RedPacketAccountRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
@DubboService(version = "1.0.0")
public class RedPacketAccountServiceImpl implements RedPacketAccountService {

    @Autowired
    RedPacketAccountRepository redPacketAccountRepository;

    @Override
    public BigDecimal getRedPacketAccountByUserId(long userId) {
        return redPacketAccountRepository.findByUserId(userId).getBalanceAmount();
    }
}
