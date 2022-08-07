package com.fancv.dubbo.order.service;

import com.fancv.dubbo.api.capital.CapitalAccountService;
import com.fancv.dubbo.api.redpacket.RedPacketAccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
@Service("accountService")
public class AccountServiceImpl {

    @DubboReference(check = false,version = "1.0.0")
    RedPacketAccountService redPacketAccountService;

    @DubboReference(check = true,version = "1.0.0")
    CapitalAccountService capitalAccountService;


    public BigDecimal getRedPacketAccountByUserId(long userId) {
        return redPacketAccountService.getRedPacketAccountByUserId(userId);
    }

    public BigDecimal getCapitalAccountByUserId(long userId) {
        return capitalAccountService.getCapitalAccountByUserId(userId);
    }
}
