package com.fancv.dubbo.order.dao;


import com.fancv.dubbo.order.domain.entity.OrderLine;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by changming.xie on 4/1/16.
 */
@Mapper
public interface OrderLineDao {
    void insert(OrderLine orderLine);
}
