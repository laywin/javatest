/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-06-13 16:10 创建
 *
 */
package com.yx.javatest.execsequence;

/**
 * @author yanqing@yiji.com
 */
public enum  TestCls001 {
    MAN("MAN"),
    WOMEN("WOMEN");

    private final String personType;

    static{
        System.out.println("enum static block");
    }

    TestCls001(String str){
        personType = str;
        System.out.println("enum construct block");
    }

    public static void main(String[] args){
        System.out.println(TestCls001.valueOf("aa"));
    }
}
