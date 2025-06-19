package com.xlx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.xlx.entity")
public class XgMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(XgMallApplication.class,args);
    }
}
