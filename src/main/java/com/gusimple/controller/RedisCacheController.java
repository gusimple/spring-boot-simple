package com.gusimple.controller;

import com.gusimple.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/16 16:46
 **/
@RestController
@RequestMapping("/reids")
public class RedisCacheController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheController.class);

    @Autowired
    private RedisTemplate<String,Serializable> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0,1000).forEach(i ->executorService.execute(()-> stringRedisTemplate.opsForValue().increment("kk",1)));
        stringRedisTemplate.opsForValue().set("k1","k2");
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        LOGGER.info("[缓存结果] - [{}]",k1);

        String key="gusimple:user:1";
        redisTemplate.opsForValue().set(key,new User("uq","123"));
        User user = (User)redisTemplate.opsForValue().get(key);
        LOGGER.info("[对象缓存结果] - [{}]",user);
    }
}
