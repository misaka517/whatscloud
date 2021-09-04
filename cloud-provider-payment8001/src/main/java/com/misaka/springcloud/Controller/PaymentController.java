package com.misaka.springcloud.Controller;

import com.misaka.springcloud.entities.CommonResult;
import com.misaka.springcloud.entities.Payment;
import com.misaka.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 517
 * @date 2021-08-18 - 22:27
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("id = {},body = {}",payment.getId(),payment.getSerial());
        int result = paymentService.create(payment);
        log.info("---插入结果：{}" ,result);
        if(result > 0){
            return new CommonResult(200,"插入成功" + "来自 = " + serverPort,result);
        }
        else {
            return new CommonResult(444,"插入失败",null);
        }
    };

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("---查询结果：{}" ,payment);
        if(null != payment){
            return new CommonResult(200,"查询成功,port:" + serverPort,payment);
        }
        else {
            return new CommonResult(444,"查询失败",null);
        }
    };

}
