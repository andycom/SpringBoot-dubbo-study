package com.fancv.dubbo.order.service;

import com.fancv.dubbo.order.domain.entity.Order;
import com.fancv.dubbo.order.domain.factory.OrderFactory;
import com.fancv.dubbo.order.domain.repository.OrderRepository;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by changming.xie on 3/25/16.
 */
@Service
public class OrderServiceImpl {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderFactory orderFactory;

    @Transactional
    public Order createOrder(long payerUserId, long payeeUserId, List<Pair<Long, Integer>> productQuantities) {
        Order order = orderFactory.buildOrder(payerUserId, payeeUserId, productQuantities);

        orderRepository.create(order);

        return order;
    }

    public void update(Order order) {
        orderRepository.update(order);
    }


    public Order findOrderByMerchantOrderNo(String orderNo) {
        return orderRepository.findByMerchantOrderNo(orderNo);
    }
}
