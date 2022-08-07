package com.fancv.tcc.captial.service.impl;

import com.fancv.dubbo.api.capital.CapitalAccountService;
import com.fancv.tcc.captial.repository.CapitalAccountRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
@DubboService(version = "1.0.0")
public class CapitalAccountServiceImpl implements CapitalAccountService {

    @Autowired
    CapitalAccountRepository capitalAccountRepository;

    @Override
    public BigDecimal getCapitalAccountByUserId(long userId) {
        return capitalAccountRepository.findByUserId(userId).getBalanceAmount();
    }
}
