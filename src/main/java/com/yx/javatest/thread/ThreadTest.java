/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-06-27 16:35 创建
 *
 */
package com.yx.javatest.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author yanqing@yiji.com
 */
public class ThreadTest {

    @Test
    public void testThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
//         Thread thread1 = new Thread(new Runnable() {
//
//
//
//             @Override
//             public void run() {
//                 try {
//                     lock.wait(1000L);
//                     System.out.println("hello");
//                     countDownLatch.countDown();
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         });
//        thread1.start();
        MyThread myThread = new MyThread();
        myThread.start();
        countDownLatch.await();
    }

    public static class MyThread extends Thread{
        private Object lock = new Object();

        @Override
        public void run(){
            try {
                synchronized(lock) {
                    lock.wait(1000L);
                    System.out.println("hello");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test001(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("start to reject task.. ");
            }
        });
        int i = 0;
        while(true){
            threadPoolExecutor.submit(new MyRunable(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++i;
        }

    }

    public static class MyRunable implements Runnable{

        private int index;
        public MyRunable(int i){
            this.index = i;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("work" + index + " hello..");
                try {
                    Thread.sleep(5000);
                    ++index;
//                if(Thread.currentThread().isInterrupted()){
//                    break;
//                }
//                try {
//
                } catch (InterruptedException e) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("thread: interrupt");
                    }else{
                        System.out.println("thread: not interrupt");
                    }
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    @Test
    public void test002() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(new MyRunable(0));
        thread.join();
        thread.start();
        Thread.sleep(7000);
        thread.interrupt();
        if(thread.isInterrupted()){
            System.out.println("interrupted");
        }else{
            System.out.println("not interrupted");
        }
        countDownLatch.countDown();
        countDownLatch.await();
    }

    public static class CountTask extends RecursiveTask<Integer>{

        @Override
        protected Integer compute() {
            this.fork();
            this.join();
            return null;
        }
    }
}
