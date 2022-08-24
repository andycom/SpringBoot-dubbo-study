package com.fancv.tcc.card;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.fancv.tcc.card.service")
public class DubboCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboCardApplication.class, args);
    }
}
