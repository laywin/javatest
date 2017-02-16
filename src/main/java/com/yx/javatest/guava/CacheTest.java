/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-02-13 18:11 创建
 *
 */
package com.yx.javatest.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yanqing@yiji.com
 */
public class CacheTest {

    static {
        Map<String,String> dataMap = Maps.newConcurrentMap();
        dataMap.put("1","a");
        dataMap.put("2","b");
        dataMap.put("3","c");
        loadingCache = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return dataMap.get(key);
            }
        });
    }

    private static LoadingCache<String, String> loadingCache;

    @Test
    public void test001(){
        try {
            String key = "4";
            System.out.println(loadingCache.get(key, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return key + " not absent";
                }
            }));

            loadingCache.asMap();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
