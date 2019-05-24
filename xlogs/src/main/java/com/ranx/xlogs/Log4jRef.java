package com.ranx.xlogs;

import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

/**
 * log4j
 * @author ranx
 * @create 2019-05-23 19:26
 *
 **/
public class Log4jRef extends AbsLog {
    private static Logger log4j = Logger.getLogger(Log4jRef.class);

    public  void runThread(CountDownLatch cdl){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j=0; j< 2 * 10000; j++) {
                    log4j.info("Hello log4j");
                }
                cdl.countDown();
            }
        }).start();
    }

    public  void logSpeedTime(long speedTime) {
        log4j.info("Times: " + speedTime + "s");
    }

}
