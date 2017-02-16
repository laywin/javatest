/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-25 10:29 创建
 *
 */
package com.yx.javatest.proxy.JDKDynamic;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yanqing@yiji.com
 */
public class JDKDynamicTest {

    @Test
    public void test001() throws IllegalAccessException, InstantiationException {
        Class<?> tmpClass = Proxy.getProxyClass(MyClass.class.getClassLoader(),MyClass.class.getInterfaces());

        MyInterface proxyClass = (MyInterface)tmpClass.newInstance();

        proxyClass.show();
    }

    public static class MyClass implements MyInterface{

        public void show() {
            System.out.println("hello world");
        }
    }

    public static class MyInvocationHandler implements InvocationHandler{

        private Object proxyedObj;

        public MyInvocationHandler(Object object){
            this.proxyedObj = object;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            return method.invoke(proxyedObj,args);
        }
    }


}


