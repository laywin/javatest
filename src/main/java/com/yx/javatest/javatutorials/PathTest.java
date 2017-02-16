/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-22 15:59 创建
 *
 */
package com.yx.javatest.javatutorials;

import com.sun.jndi.toolkit.url.Uri;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yanqing@yiji.com
 */
public class PathTest {

    private Logger logger = LoggerFactory.getLogger(PathTest.class);

    @Test
    public void test001(){
        Path path = Paths.get("c://user/yiji");

        logger.info(path.toString());

        logger.info(path.getFileName().toString());

        logger.info(path.getRoot().toString());

        logger.info(path.subpath(0,2).toString());

    }

    @Test
    public void test002(){
        Path path = Paths.get("//home//software");
        logger.info(path.toAbsolutePath().toString());

        URI uri = path.toUri();
        System.out.println(uri.toString());
    }
}
