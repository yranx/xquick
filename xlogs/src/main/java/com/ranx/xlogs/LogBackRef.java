package com.ranx.xlogs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * logBack
 * @author ranx
 * @create 2019-05-23 19:26
 *
 **/
public class LogBackRef extends AbsLog {

    private final static Logger logback = LoggerFactory.getLogger(LogBackRef.class);

    @Override
    public void runThread(CountDownLatch cdl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j=0; j< 2 * 10000; j++) {
                    logback.info("Hello logback");
                }
                cdl.countDown();
            }
        }).start();
    }

    @Override
    public void logSpeedTime(long speedTime) {
        logback.info("Times: " + speedTime + "s");
    }
}
