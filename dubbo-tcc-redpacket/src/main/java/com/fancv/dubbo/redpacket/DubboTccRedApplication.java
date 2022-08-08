package com.fancv.dubbo.redpacket;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.fancv.dubbo.redpacket.service")
public class DubboTccRedApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboTccRedApplication.class, args);
    }

}
