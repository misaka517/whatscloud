package com.misaka.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author 517
 * @date 2021-09-07 - 22:43
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "ThreadPool "+ Thread.currentThread().getName() + " paymentInfo ok " +id;
    }

    public String paymentInfo_OK_Timeout(Integer id){
        return "ThreadPool "+ Thread.currentThread().getName() + " paymentInfo ok " +id;
    }
}
