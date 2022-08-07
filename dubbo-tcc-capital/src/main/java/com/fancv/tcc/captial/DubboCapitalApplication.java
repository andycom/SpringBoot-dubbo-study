package com.fancv.tcc.captial;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.fancv.tcc.captial.service.impl")
public class DubboCapitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboCapitalApplication.class, args);
    }
}
