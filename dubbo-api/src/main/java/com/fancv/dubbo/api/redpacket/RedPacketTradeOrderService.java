package com.fancv.dubbo.api.redpacket;

import org.mengyun.tcctransaction.api.EnableTcc;
import com.fancv.dubbo.api.redpacket.dto.RedPacketTradeOrderDto;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface RedPacketTradeOrderService {

    @EnableTcc
    public String record(RedPacketTradeOrderDto tradeOrderDto);
}
