/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-18 17:52 创建
 *
 */
package com.yx.javatest.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author yanqing@yiji.com
 */
public class MethodDelegate {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        MyClass obj = new ByteBuddy()
                .subclass(MyClass.class)
                .method(named("hello")).intercept(MethodDelegation.to(DelegationClass.class))
                .make()
                .load(Main.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded()
                .newInstance();

        System.out.println(obj.hello());

    }

    public static class MyClass {

        public String hello() {
            return null;
        }
    }

    public static class DelegationClass{

        public static String hello(){
            return "delegationClass";
        }
    }
}
