package com.dolphintwo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dd on 2018/8/31 16:29
 */

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/redis")
    public String redisHandler(){
        stringRedisTemplate.opsForValue().set("k1", "Springboot redis");
        return stringRedisTemplate.opsForValue().get("k1");
    }
}
