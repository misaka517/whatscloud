package com.misaka.springcloud.service.impl;

import com.misaka.springcloud.Dao.PaymentDao;
import com.misaka.springcloud.entities.Payment;
import com.misaka.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.junit.rules.Timeout;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 517
 * @date 2021-08-18 - 22:11
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallBackVoid",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String HystrixTest(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "get Hystrix payment" + Thread.currentThread().getName() + "ok" + id;
    }

    public String fallBackVoid(Integer id){
        return "Timeout + " + Thread.currentThread().getName() + "paymentInfo_Timeout" + id;
    }
}
