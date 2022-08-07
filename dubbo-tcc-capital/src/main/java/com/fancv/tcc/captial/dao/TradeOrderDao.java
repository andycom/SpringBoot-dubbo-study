package com.fancv.tcc.captial.dao;


import com.fancv.tcc.captial.entity.TradeOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by twinkle.zhou on 16/11/14.
 */
@Mapper
public interface TradeOrderDao {

    int insert(TradeOrder tradeOrder);

    int update(TradeOrder tradeOrder);

    TradeOrder findByMerchantOrderNo(String merchantOrderNo);
}
