package com.gh.firstdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/1 9:42
 */
@Repository
public class StudentRepository {
    @SuppressWarnings("unused")
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("unused")
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<String, String> valueOperations;

    public void saveString(String key, String value){
        valueOperations.set(key, value);
    }

    public String getString(String key) {
        return valueOperations.get(key);
    }
}
