package com.fancv.dubbo.api.capital;

import com.fancv.dubbo.api.capital.dto.CapitalTradeOrderDto;
import org.mengyun.tcctransaction.api.EnableTcc;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface CapitalTradeOrderService {

    @EnableTcc
    public String record(CapitalTradeOrderDto tradeOrderDto);

}
