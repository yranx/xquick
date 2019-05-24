package com.ranx.xlogs;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.CountDownLatch;

/**
 * log4j2
 * @author ranx
 * @create 2019-05-23 19:26
 *
 **/
public class Log4j2Ref extends AbsLog {

    private static Logger log4j2 = LogManager.getLogger(Log4j2Ref.class);

    @Override
    public void runThread(CountDownLatch cdl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j=0; j< 2 * 10000; j++) {
                    log4j2.info("Hello Log4j2");
                }
                cdl.countDown();
            }
        }).start();
    }

    @Override
    public void logSpeedTime(long speedTime) {
        log4j2.info("Times: " + speedTime + "s");
    }
}
