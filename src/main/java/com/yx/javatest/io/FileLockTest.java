/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-01-22 12:07 创建
 *
 */
package com.yx.javatest.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * @author yanqing@yiji.com
 */
public class FileLockTest {

    public static void echo(Object str) {
        System.out.println(str);
    }

    @Test
    public void test01() {
        File file = new File("D:\\年终总结.md");

        //给该文件加锁
        try {
            RandomAccessFile fis = new RandomAccessFile(file, "rw");

            FileChannel fileChannel = fis.getChannel();
            fileChannel.tryLock();
            echo("size: " + fileChannel.size());
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            echo(byteBuffer.toString());
//            while (true) {
                fileChannel.read(byteBuffer);
                byteBuffer.flip();
            echo("after read............");
            echo(byteBuffer.toString());

//            byteBuffer.get()
            echo(byteBuffer.toString());

//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
