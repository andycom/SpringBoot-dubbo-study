package com.fancv.dubbo.api.capital;

import org.mengyun.tcctransaction.api.EnableTcc;

import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
public interface CapitalAccountService {

    @EnableTcc
    BigDecimal getCapitalAccountByUserId(long userId);
}
