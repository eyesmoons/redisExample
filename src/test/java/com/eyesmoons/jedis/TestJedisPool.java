package com.eyesmoons.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

import java.util.List;

public class TestJedisPool {
    private static JedisPool pool = null;
    private static Jedis jedis = null;

    @Before
    public void before(){
        String ipAddr = "192.168.109.102";
        int port = Protocol.DEFAULT_PORT;

        pool = new JedisPool(ipAddr, port);
        jedis = pool.getResource();
    }

    @After
    public void after(){
        jedis.close();
    }

    @Test
    public void testString(){
        String str = jedis.mset("food1", "noodles", "food2", "rice");

        List<String> list = jedis.mget("food1","food2");
        for (String item : list) {
            System.out.println(item);
        }

    }
}
