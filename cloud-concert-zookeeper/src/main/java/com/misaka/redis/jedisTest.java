package com.misaka.redis;

import io.netty.util.Timeout;
import redis.clients.jedis.Jedis;

/**
 * @author 517
 * @date 2021-10-09 - 14:35
 */
public class jedisTest {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("node10",6379,60000);
        System.out.println(jedis.ping());
        jedis.set("517","hong");
        jedis.set("416","zheng");
        jedis.set("315","rong");
        String s = jedis.get("517");
        jedis.setex("112",4,"have");
        System.out.println(jedis.get("112"));
        Thread.sleep(4000);
        String s1 = jedis.get("112");
        System.out.println(s1);
        System.out.println(s);

    }
}
