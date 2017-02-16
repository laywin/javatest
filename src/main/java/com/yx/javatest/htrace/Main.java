/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-20 14:41 创建
 *
 */
package com.yx.javatest.htrace;

import org.apache.htrace.core.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanqing@yiji.com
 */
public class Main {

    public static void main(String[] args) {
        Map<String, String> mapConfig = new HashMap<>();
        mapConfig.put("span.receiver.classes", "LocalFileSpanReceiver");
        mapConfig.put("sampler.classes","AlwaysSampler");
        mapConfig.put("local.file.span.receiver.path","D:\\htrace.txt");
        Tracer tracer = new Tracer.Builder("tracer").
                conf(HTraceConfiguration.fromMap(mapConfig)).
                tracerPool(new TracerPool("TestSimpleScope")).
                build();

        try(TraceScope traceScope = tracer.newScope("Foo")) {
            Span span = traceScope.getSpan();
            try(TraceScope childTraceScope = tracer.newScope("childScope",span.getSpanId())) {
                System.out.println("hello world");
            }
        }
        tracer.close();
//        Tracer tracer = new Tracer.Builder().
//                name("TestSimpleScope").
//                tracerPool(new TracerPool("TestSimpleScope")).
//                conf(HTraceConfiguration.fromKeyValuePairs(
//                        "sampler.classes", "AlwaysSampler")).
//                build();
//        POJOSpanReceiver receiver =
//                new POJOSpanReceiver(HTraceConfiguration.EMPTY);
//        tracer.getTracerPool().addReceiver(receiver);
//        TraceScope scope = tracer.newScope("Foo");
//        scope.close();
//        tracer.close();
//        Assert.assertEquals(1, receiver.getSpans().size());
//        Span span = receiver.getSpans().iterator().next();
//        Assert.assertEquals(0, span.getParents().length);

    }
}
