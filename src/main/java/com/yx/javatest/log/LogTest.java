/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-06-01 10:44 创建
 *
 */
package com.yx.javatest.log;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yanqing@yiji.com
 */
public class LogTest {

    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        Calendar instance = Calendar.getInstance();
        instance.setLenient(true);
        instance.add(Calendar.HOUR_OF_DAY, 1);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        logger.info("hello world");
//        for(int i = 0;i < 2;++i) {
//            if(i == 0) {
//                MDC.put("hello", "world");
//            }else{
//                MDC.put("hello", "world1");
//            }
//            logger.info("in parent thread");
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    logger.info("in child thread");
//                }
//            });
//        }
//        Thread a;
//        new Thread(() -> {
//            logger.info("that is all right!");
//        }).start();
//        int i = 0;
//        while(true) {
//            ++i;
//            if(i % 10 == 0) {
//                log(Level.DEBUG);
//            }
//            else {
//                log(Level.INFO);
//            }
//            Thread.sleep(1000);
//        }
    }

//    public static void log(Level level) {
//        if (logger instanceof ch.qos.logback.classic.Logger) {
//            ch.qos.logback.classic.Logger logBacklogger = (ch.qos.logback.classic.Logger) logger;
//            logBacklogger.setLevel(level);
//        }
//        logger.debug("debug log");
//        logger.info("info log");
//    }
}
