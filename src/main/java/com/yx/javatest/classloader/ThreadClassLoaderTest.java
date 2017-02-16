/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-06-16 23:44 创建
 *
 */
package com.yx.javatest.classloader;

/**
 * @author yanqing@yiji.com
 */
public class ThreadClassLoaderTest {

    public static void main(String[] args){
//        WrapClassLoader wrapClassLoader = new WrapClassLoader();
//        Thread thread1 = new Thread(() -> {
//            wrapClassLoader.setClassLoader1(Thread.currentThread().getContextClassLoader());
//        });
//
//        Thread thread2 = new Thread(() -> {
//            wrapClassLoader.setClassLoader2(Thread.currentThread().getContextClassLoader());
//        });
//        thread1.start();
//        thread2.start();
//
//        ClassLoader classLoader1 = wrapClassLoader.getClassLoader1();
//        ClassLoader classLoader2 = wrapClassLoader.getClassLoader2();
//        System.out.println(ThreadClassLoaderTest.class.getClassLoader());
//        System.out.println(Thread.currentThread().getContextClassLoader());
//        System.out.println(classLoader1);
//        if(classLoader1 == classLoader2 && classLoader1 == ThreadClassLoaderTest.class.getClassLoader()){
//            System.out.println("classLoader1 == classLoader2");
//        }else{
//            System.out.println("classLoader1 != classLoader2");
//        }
    }

    public static class WrapClassLoader{

        private ClassLoader classLoader1;

        private  ClassLoader classLoader2;

        public ClassLoader getClassLoader1() {
            return classLoader1;
        }

        public void setClassLoader1(ClassLoader classLoader1) {
            this.classLoader1 = classLoader1;
        }

        public ClassLoader getClassLoader2() {
            return classLoader2;
        }

        public void setClassLoader2(ClassLoader classLoader2) {
            this.classLoader2 = classLoader2;
        }
    }
}
