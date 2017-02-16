/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-10-24 15:48 创建
 *
 */
package com.yx.javatest.exporter;

import java.util.concurrent.CountDownLatch;

/**
 * @author yanqing@yiji.com
 */
public class MainCls {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args){
        try {
            Config.export();
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
