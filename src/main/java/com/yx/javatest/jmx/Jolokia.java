/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-06-08 14:50 创建
 *
 */
package com.yx.javatest.jmx;

import org.jolokia.client.J4pClient;
import org.jolokia.client.exception.J4pException;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;
import org.junit.Test;

import javax.management.MalformedObjectNameException;
import java.util.Map;

/**
 * @author yanqing@yiji.com
 */
public class Jolokia {

    @Test
    public void test1() throws MalformedObjectNameException, J4pException {
        J4pClient j4pClient = new J4pClient("http://127.0.0.1:3099/jolokia");
        J4pReadRequest req = new J4pReadRequest("java.lang:type=Memory",
                "HeapMemoryUsage");
        J4pReadResponse resp = j4pClient.execute(req);
        Map<String,String> vals = resp.getValue();
        int used = Integer.parseInt(vals.get("used"));
        int max = Integer.parseInt(vals.get("max"));
        int usage = (int) (used * 100 / max);
        System.out.println("Memory usage: used: " + used +
                " / max: " + max + " = " + usage + "%");
    }
}
