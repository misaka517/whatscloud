package com.misaka.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 517
 * @date 2021-09-04 - 17:20
 */


@Configuration

public class mySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
