package com.fancv.dubbo.order.domain.repository;


import com.fancv.dubbo.order.dao.OrderDao;
import com.fancv.dubbo.order.dao.OrderLineDao;
import com.fancv.dubbo.order.domain.entity.Order;
import com.fancv.dubbo.order.domain.entity.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

/**
 * Created by changming.xie on 4/1/16.
 */
@Repository
public class OrderRepository {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderLineDao orderLineDao;

    public void create(Order order) {
        orderDao.insert(order);

        for (OrderLine orderLine : order.getOrderLines()) {
            orderLineDao.insert(orderLine);
        }
    }

    public void update(Order order) {
        order.updateVersion();
        int effectCount = orderDao.update(order);

        if (effectCount < 1) {
            throw new OptimisticLockingFailureException("update order failed");
        }
    }

    public Order findByMerchantOrderNo(String merchantOrderNo) {
        return orderDao.findByMerchantOrderNo(merchantOrderNo);
    }
}
