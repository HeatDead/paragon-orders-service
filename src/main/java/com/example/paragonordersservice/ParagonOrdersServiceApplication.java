package com.example.paragonordersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ParagonOrdersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParagonOrdersServiceApplication.class, args);
    }
}