package com.fancv.dubbo.order.service;

import com.fancv.api.CarDTO;
import com.fancv.api.MyOutService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarService {

    @DubboReference(check = false, version = "1.0.0",mock = "com.fancv.dubbo.order.service.MockCarService")
    MyOutService myOutService;


    public CarDTO getCarInfoLocal(String name) {
        try {
            return myOutService.getCarInfo(name);
        } catch (RpcException e) {
            log.error("远程调用失败", e);

        } catch (Exception e) {
            log.error("其他异常", e);
        }
        return null;
    }
}
