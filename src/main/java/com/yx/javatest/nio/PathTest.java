/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-01-23 11:25 创建
 *
 */
package com.yx.javatest.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yanqing@yiji.com
 */
public class PathTest {

    public static void echo(Object str) {
        System.out.println(str);
    }

    @Test
    public void test001(){
        Path path = Paths.get("c:\\elasticsearch","settings.gradle");

        echo("文件路径：" + path.toString());
        echo("root: " + path.getRoot());
        echo("url: " + path.toUri());

        Path p1 = Paths.get("joe");
        Path p2 = Paths.get("sally");

        echo(p1.relativize(p2));
        echo(p2.relativize(p1));

        ByteBuffer byteBuffer;

//        byteBuffer.allocate(10);

//        path.toRealPath();
        assert Files.exists(path);
    }


}
