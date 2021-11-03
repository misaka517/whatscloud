package com.misaka.springcloud.cache.redis;

import com.misaka.springcloud.entities.Payment;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

/**
 * @author 517
 * @date 2021-10-18 - 17:18
 */

@SpringBootTest
public class templateTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void TestTemplate(){
        redisTemplate.opsForValue().set("416","aafaaafaa");
        Object o1 = redisTemplate.opsForValue().get("416");
        System.out.println(o1);
    }

    @Test
    void pojoTest() throws IOException {
        Payment payment = new Payment();
        payment.setId(4L);
        payment.setSerial("ssfad");
        byte[] objectMapper = new ObjectMapper().writeValueAsBytes(payment);
        String obj = new String(objectMapper);
        redisTemplate.opsForValue().set("dingdan",payment);
        System.out.println(redisTemplate.opsForValue().get("dingdan"));
    }
}
