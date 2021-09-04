package com.misaka.springcloud;

import com.misaka.myrule.mySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 517
 * @date 2021-08-28 - 16:01
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "cloud-payment-service",configuration = mySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
