package com.fancv.dubbo.order.service;

import com.fancv.dubbo.api.capital.CapitalTradeOrderService;
import com.fancv.dubbo.api.capital.dto.CapitalTradeOrderDto;
import com.fancv.dubbo.api.card.CardService;
import com.fancv.dubbo.api.redpacket.RedPacketTradeOrderService;
import com.fancv.dubbo.api.redpacket.dto.RedPacketTradeOrderDto;
import com.fancv.dubbo.order.domain.entity.Order;
import com.fancv.dubbo.order.domain.repository.OrderRepository;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.UniqueIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by changming.xie on 4/1/16.
 */
@Service
public class PaymentServiceImpl {

    @DubboReference(check = true, version = "1.0.0", timeout = 5000, retries = 0)
    CapitalTradeOrderService capitalTradeOrderService;

    @DubboReference(check = false , version = "1.0.0", timeout = 5000, retries = 0)
    RedPacketTradeOrderService redPacketTradeOrderService;

    @DubboReference(check = true , version = "1.0.0", timeout = 5000, retries = 0)
    CardService cardService;

    @Autowired
    OrderRepository orderRepository;

    @Compensable(confirmMethod = "confirmMakePayment", cancelMethod = "cancelMakePayment", asyncConfirm = false)
    public void makePayment(@UniqueIdentity String orderNo) {
        System.out.println("order try make payment called.time seq:" + DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));

        Order order = orderRepository.findByMerchantOrderNo(orderNo);


        try {
            String a = cardService.record(11);
            String result = capitalTradeOrderService.record(buildCapitalTradeOrderDto(order));

            String result2 = redPacketTradeOrderService.record(buildRedPacketTradeOrderDto(order));
        } catch (Exception e) {
            throw e;
        }
    }

    public void confirmMakePayment(String orderNo) {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("order confirm make payment called. time seq:" + DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));

        Order foundOrder = orderRepository.findByMerchantOrderNo(orderNo);

        //check if the trade order status is PAYING, if no, means another call confirmMakePayment happened, return directly, ensure idempotency.
        if (foundOrder != null) {
            foundOrder.confirm();
            orderRepository.update(foundOrder);
        }
    }

    public void cancelMakePayment(String orderNo) {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("order cancel make payment called.time seq:" + DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));

        Order foundOrder = orderRepository.findByMerchantOrderNo(orderNo);

        //check if the trade order status is PAYING, if no, means another call cancelMakePayment happened, return directly, ensure idempotency.
        if (foundOrder != null) {
            foundOrder.cancelPayment();
            orderRepository.update(foundOrder);
        }
    }


    private CapitalTradeOrderDto buildCapitalTradeOrderDto(Order order) {

        CapitalTradeOrderDto tradeOrderDto = new CapitalTradeOrderDto();
        tradeOrderDto.setAmount(order.getCapitalPayAmount());
        tradeOrderDto.setMerchantOrderNo(order.getMerchantOrderNo());
        tradeOrderDto.setSelfUserId(order.getPayerUserId());
        tradeOrderDto.setOppositeUserId(order.getPayeeUserId());
        tradeOrderDto.setOrderTitle(String.format("order no:%s", order.getMerchantOrderNo()));

        return tradeOrderDto;
    }

    private RedPacketTradeOrderDto buildRedPacketTradeOrderDto(Order order) {
        RedPacketTradeOrderDto tradeOrderDto = new RedPacketTradeOrderDto();
        tradeOrderDto.setAmount(order.getRedPacketPayAmount());
        tradeOrderDto.setMerchantOrderNo(order.getMerchantOrderNo());
        tradeOrderDto.setSelfUserId(order.getPayerUserId());
        tradeOrderDto.setOppositeUserId(order.getPayeeUserId());
        tradeOrderDto.setOrderTitle(String.format("order no:%s", order.getMerchantOrderNo()));

        return tradeOrderDto;
    }
}
