/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-08-10 23:11 创建
 *
 */
package com.yx.javatest.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author yanqing@yiji.com
 */
public class Test001 {

    @Test
    public void overrideMethod() throws IllegalAccessException, InstantiationException {
         Class<?> dynamicClass = new ByteBuddy().subclass(Object.class).
                 method(ElementMatchers.named("toString")).intercept(FixedValue.value("hello world"))
                 .make()
                 .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                 .getLoaded();

        System.out.println(dynamicClass.newInstance().toString());
        assertThat(dynamicClass.newInstance().toString(),is("hello world"));
    }
}
