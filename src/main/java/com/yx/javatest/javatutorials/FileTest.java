/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-23 10:41 创建
 *
 */
package com.yx.javatest.javatutorials;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 * @author yanqing@yiji.com
 */
public class FileTest {

    @Test
    public void test001() {
        Path pathsource = Paths.get("E:\\htrace.txt");
        FileSystem fs = pathsource.getFileSystem();
        Path pathDest = Paths.get("/htrace.txt");
        FileSystem fsDest = pathDest.getFileSystem();
        Boolean isWritable = Files.isWritable(pathDest);
        System.getSecurityManager().checkSecurityAccess(pathDest.toString());
        try {
            Path path = Files.move(pathsource, pathDest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test002() throws IOException {
        Path path = Paths.get("E:\\htrace.txt");

        try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);

            while (channel.read(byteBuffer) > 0) {
                byteBuffer.rewind();

                System.out.print(Charset.forName("UTF-8").decode(byteBuffer));

                byteBuffer.flip();
            }
        }
    }
}
