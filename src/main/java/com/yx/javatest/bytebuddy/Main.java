/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-16 18:00 创建
 *
 */
package com.yx.javatest.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * @author yanqing@yiji.com
 */
public class Main {


     public static void main(String[] args) throws IllegalAccessException, InstantiationException {
         Foo foo = new ByteBuddy()
                   .subclass(Foo.class)
                   .method(named("foo")).intercept(FixedValue.value("two!"))
                   .method(named("foo").and(takesArguments(1))).intercept(FixedValue.value("three!"))
                   .method(isDeclaredBy(Foo.class)).intercept(FixedValue.value("one!"))
                   .make()
                   .load(Main.class.getClassLoader(),ClassLoadingStrategy.Default.WRAPPER)
                   .getLoaded()
                   .newInstance();

         System.out.println(foo.bar());

         System.out.println(foo.foo());

         System.out.println(foo.foo("hello"));
     }

    public void testMethod1() throws IllegalAccessException, InstantiationException {
//        Class<? extends java.util.function.Function> dynamicType = new ByteBuddy()
//                .subclass(java.util.function.Function.class)
//                .method(named("apply"))
//                .intercept(MethodDelegation.to(new GreetingInterceptor()))
//                .make()
//                .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
//                .getLoaded();
//        System.out.println(dynamicType.newInstance().apply("bytebuddy"));
    }

    public void testMethod2() throws IllegalAccessException, InstantiationException {
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make()
                .load(Main.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        System.out.println(dynamicType.newInstance().toString());
    }

    public class GreetingInterceptor{

        public String greet(Object argument) {
            return "Hello from " + argument;
        }
    }

    public static class Foo {
        public String bar() { return null; }
        public String foo() { return null; }
        public String foo(Object o) { return null; }
    }
}
