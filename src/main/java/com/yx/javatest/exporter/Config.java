/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-10-24 15:43 创建
 *
 */
package com.yx.javatest.exporter;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.elasticsearch.metrics.ElasticsearchReporter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author yanqing@yiji.com
 */
public class Config {


    public static void export() {
        final MetricRegistry registry = new MetricRegistry();
        ElasticsearchReporter reporter = null;
        try {
            reporter = ElasticsearchReporter.forRegistry(registry)
                    .hosts("192.168.45.213:9201")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        reporter.start(5, TimeUnit.SECONDS);

        Meter incomingRequestsMeter = registry.meter("incoming-http-requests");

        incomingRequestsMeter.mark(1);
    }
}
