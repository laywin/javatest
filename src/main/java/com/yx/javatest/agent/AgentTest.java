/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-08-15 16:06 创建
 *
 */
package com.yx.javatest.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.isAnnotatedWith;
import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author yanqing@yiji.com
 */
public class AgentTest {

    public static void premain(String arguments, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(isAnnotatedWith(ToString.class))
                .transform(new AgentBuilder.Transformer() {

                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader) {

                        return builder.method(named("toString"))
                                .intercept(FixedValue.value("transformed"));
                    }
                }).installOn(instrumentation);
    }
}
