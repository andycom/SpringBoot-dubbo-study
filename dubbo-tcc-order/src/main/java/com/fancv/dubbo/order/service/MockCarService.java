package com.fancv.dubbo.order.service;

import com.fancv.api.CarDTO;
import com.fancv.api.MyOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MockCarService implements MyOutService {
    @Override
    public CarDTO getCarInfo(String userName) {

        CarDTO carDTO = new CarDTO("local", 78, "china");
        log.info("Local Mock Service");
        return carDTO;
    }
}
