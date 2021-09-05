package com.fancv.dubbo.api.BO;

import lombok.Builder;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 *
 */
@Builder
@Configuration
public class User implements Serializable {

    private String name;

    private Integer age;

    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
