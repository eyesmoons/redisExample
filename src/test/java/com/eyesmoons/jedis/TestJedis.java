package com.eyesmoons.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestJedis {
    private static Jedis jedis = null;
    @Before
    public void before(){
        String ipAddr = "192.168.109.102";
        int port = Protocol.DEFAULT_PORT;

        jedis = new Jedis(ipAddr, port);
    }

    @After
    public void after(){
        jedis.close();
    }

    @Test
    public void testString(){
        String result = jedis.set("name", "zhangsan");

        System.out.println(jedis.get("name"));
    }

    @Test
    public void testList(){
        Long lpushResult = jedis.lpush("fruitList", "apple", "orange", "banana", "peach");

        List<String> list = jedis.lrange("fruitList", 0, -1);

        for (String item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void testSet(){
        jedis.sadd("animal","dog","cat","tiger","panda");

        Set<String> set = jedis.smembers("animal");

        for (String item : set) {
            System.out.println(item);
        }
    }

    @Test
    public void testHash(){
        jedis.hset("user","name","zhangsan");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("age","21");
        map.put("sex","男");
        jedis.hmset("user",map);

        Map<String, String> user = jedis.hgetAll("user");

        Set<Map.Entry<String, String>> entries = user.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
    }

    @Test
    public void testZset(){
        jedis.zadd("chengji",98,"xiaoming");

        HashMap<String, Double> map = new HashMap<String, Double>();
        map.put("xiaohua",90.0);
        map.put("xiaogang",10.0);
        jedis.zadd("chengji",map);

        /*Set<String> zset = com.eyesmoons.jedis.zrange("chengji", 0, -1);
        for (String item : zset) {
            System.out.println(item);
        }*/

        Set<Tuple> zset = jedis.zrevrangeWithScores("chengji", 0, -1);

        for (Tuple tuple : zset) {
            System.out.println(tuple.getElement() + "：" + tuple.getScore());
        }

    }
}
