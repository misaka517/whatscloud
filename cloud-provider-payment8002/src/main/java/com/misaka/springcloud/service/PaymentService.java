package com.misaka.springcloud.service;

import com.misaka.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 517
 * @date 2021-08-18 - 22:24
 */
public interface PaymentService{
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
