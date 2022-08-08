package com.fancv.dubbo.redpacket.dao;


import com.fancv.dubbo.redpacket.entity.TradeOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by twinkle.zhou on 16/11/14.
 */
@Mapper
public interface TradeOrderDao {

    void insert(TradeOrder tradeOrder);

    int update(TradeOrder tradeOrder);

    TradeOrder findByMerchantOrderNo(String merchantOrderNo);
}
