package com.misaka.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 517
 * @date 2021-09-07 - 22:34
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentHystrixMain8003 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentHystrixMain8003.class,args);
    }

}
