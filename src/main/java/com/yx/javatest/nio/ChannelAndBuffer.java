/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-01-23 15:40 创建
 *
 */
package com.yx.javatest.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author yanqing@yiji.com
 */
public class ChannelAndBuffer {

    public static void echo(Object str) {
        System.out.println(str);
    }

    @Test
    public void test01(){
        try {
            FileChannel.open(Paths.get("c:\\elasticsearch","settings.gradle"));
            try(SeekableByteChannel channel =  Files.newByteChannel(Paths.get("c:\\elasticsearch","settings.gradle"))){
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                echo("limit: " + byteBuffer.limit());
                String encoding = System.getProperty("file.encoding");
                echo("file encode:" + encoding);
                while(channel.read(byteBuffer) > 0){
                    byteBuffer.flip();
                    echo(Charset.forName(encoding).decode(byteBuffer));
                    byteBuffer.rewind();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
