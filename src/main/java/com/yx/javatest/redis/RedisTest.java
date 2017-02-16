/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-05 11:04 创建
 *
 */
package com.yx.javatest.redis;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.List;

/**
 * @author yanqing@yiji.com
 */
public class RedisTest {

    @Test
     public void testRedis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean("redisTemplate",RedisTemplate.class);
        redisTemplate.opsForValue().set("hello","world");
        ListOperations<String,Person> listOperations = redisTemplate.opsForList();
        long result = listOperations.leftPush("personbb",new Person("aa"),new Person("bb"));
        System.out.println(result);
        List<Person> list = listOperations.range("personbb",0,-1);
        for(Person s : list){
            System.out.println(s.getName());
        }
     }


    @Test
    public void testSubpub(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean("redisTemplate",RedisTemplate.class);
        redisTemplate.convertAndSend("news.it","hello");
    }

   public static class Person implements Serializable{

        private String name;

        public Person(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
