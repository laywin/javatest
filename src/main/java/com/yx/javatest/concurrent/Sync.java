/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-10-29 14:11 创建
 *
 */
package com.yx.javatest.concurrent;

import org.junit.Test;

/**
 * @author yanqing@yiji.com
 */
public class Sync {

    @Test
    public void test001(){

        AddClass addClass = new AddClass();
        Thread thread1 = new Thread(new SyncRunable1(addClass));
        Thread thread2 = new Thread(new SyncRunable2(addClass));

        thread1.start();
        thread2.start();
    }

    public static class SyncRunable1 implements Runnable{

        private AddClass addClass;

        public SyncRunable1(AddClass addClass){
            this.addClass = addClass;
        }

        @Override
        public void run() {
            addClass.add1();
        }
    }

    @Test
    public void test002(){
        int a = 8;
        int b = a >>> 1;
        int d = 1 << a;
        System.out.println(b);
    }

    public static class SyncRunable2 implements Runnable{

        private AddClass addClass;

        public SyncRunable2(AddClass addClass){
            this.addClass = addClass;
        }

        @Override
        public void run() {
            addClass.add2();
        }
    }


    public static class AddClass {

        private int num = 0;

        public synchronized void add1() {
            for (int i = 0; i < 10; ++i) {
                ++num;
                System.out.println("add1...num:" + num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        public synchronized void add2() {
            for (int i = 0; i < 10; ++i) {
                ++num;
                System.out.println("add2...num:" + num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
