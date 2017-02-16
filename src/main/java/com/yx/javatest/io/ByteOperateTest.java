/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-06 16:40 创建
 *
 */
package com.yx.javatest.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yanqing@yiji.com
 */
public class ByteOperateTest {

    @Test
    public void testByteOperateTest() {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("c://config.ini");
            out = new FileOutputStream("e://config.ini");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }

                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
