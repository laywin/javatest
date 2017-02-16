/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-06 15:11 创建
 *
 */
package com.yx.javatest.io;

import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author yanqing@yiji.com
 */
public class PropertiesLoad {

    @Test
    public void testPropertiesLoad() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader() == null ?
                getClass().getClassLoader() : Thread.currentThread().getContextClassLoader();

        Properties properties = new Properties();
        InputStream inputStream = classLoader.getResourceAsStream("/MANIFEST.MF");
        if(null == inputStream){
            throw new RuntimeException("can't not found file MANIFEST.MF");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            properties.load(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("Manifest-Version"));
    }
}
