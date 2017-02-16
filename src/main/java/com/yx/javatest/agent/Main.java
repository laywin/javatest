/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-17 11:29 创建
 *
 */
package com.yx.javatest.agent;

/**
 * @author yanqing@yiji.com
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
           System.out.println(Hello.class.newInstance().toString());
    }
}
