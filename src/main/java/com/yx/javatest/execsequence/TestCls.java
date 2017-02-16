/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-06-13 15:55 创建
 *
 */
package com.yx.javatest.execsequence;

/**
 * @author yanqing@yiji.com
 */
public class TestCls {


    {
        System.out.println("this is obj init block");
    }

    private int number = 1;


    static{
        System.out.println("this is class block");
    }

    public TestCls(){
        System.out.println("this is obj construct");
    }

}
