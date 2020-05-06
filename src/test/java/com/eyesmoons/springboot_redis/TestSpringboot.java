package com.eyesmoons.springboot_redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringboot {
    @Autowired
    private StringRedisTemplate template;

    @Test
    public void testString(){
        ValueOperations<String, String> value = template.opsForValue();

        value.set("value","hello world");

        String result = value.get("value");

        System.out.println(result);
    }
}
