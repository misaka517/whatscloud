package com.misaka.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author 517
 * @date 2021-08-16 - 22:08
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class ,args);
    }
}
