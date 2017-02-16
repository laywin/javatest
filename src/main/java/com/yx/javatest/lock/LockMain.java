/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-24 11:52 创建
 *
 */
package com.yx.javatest.lock;

/**
 * class 锁测试
 * @author yanqing@yiji.com
 */
public class LockMain {

    public static Lock lock = new Lock();

    public static class Lock{
        public void show() throws InterruptedException {
             synchronized (lock) {
                 Thread.sleep(3000);
                 System.out.println("show");
             }
        }

        public synchronized void sayHello(){
            System.out.println("hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.sayHello();
            }
        });
        thread.start();
        thread1.start();
    }
}


