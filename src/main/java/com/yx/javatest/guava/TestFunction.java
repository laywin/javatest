/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-01-19 17:36 创建
 *
 */
package com.yx.javatest.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author yanqing@yiji.com
 */
public class TestFunction {

    @Test
    public void test1(){
        Map<String,String> map = Maps.newHashMap();
        map.put("hello","world");
        Function<String,String> function =  Functions.forMap(map,"default");
        System.out.println(function.apply("aa"));
    }
}
