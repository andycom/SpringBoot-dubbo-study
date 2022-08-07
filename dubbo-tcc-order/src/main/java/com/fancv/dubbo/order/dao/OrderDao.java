package com.fancv.dubbo.order.dao;


import com.fancv.dubbo.order.domain.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by changming.xie on 4/1/16.
 */
@Mapper
public interface OrderDao {

    public int insert(Order order);

    public int update(Order order);

    Order findByMerchantOrderNo(String merchantOrderNo);
}
