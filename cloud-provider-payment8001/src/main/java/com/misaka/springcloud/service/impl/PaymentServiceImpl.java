package com.misaka.springcloud.service.impl;

import com.misaka.springcloud.Dao.PaymentDao;
import com.misaka.springcloud.entities.Payment;
import com.misaka.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
