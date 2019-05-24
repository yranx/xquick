package com.ranx.xlogs;

import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

/**
 * @author ranx
 * @create 2019-05-23 19:26
 * 模板方法
 *
 * 测试代码参考 https://blog.csdn.net/yjh1271845364/article/details/70888262
 * 在同步日志模式下, Logback的性能是最糟糕的.
而log4j2的性能无论在同步日志模式还是异步日志模式下都是最佳的.
 **/
public abstract class AbsLog {
    private static final int totalThread = 50;

    /**
     * 开线程打印固定长度日志，2*1000*totalThrad行，
     * 测试写入速度，以及改变2*1000，大数据量对性能的影响
     * @throws InterruptedException
     */
    public void fixedPringting() throws InterruptedException {
        System.out.println("Start!");
        final CountDownLatch cdl = new CountDownLatch(totalThread);
        long startTime = getTime();
        for (int i=0 ;i < totalThread; i++) {
            this.runThread(cdl);
        }
        cdl.await();
        long endTime = getTime();
        long speedTime = (endTime - startTime) / 1000;
        this.logSpeedTime(speedTime);
        System.out.println("End!");
    }


    public abstract void runThread(CountDownLatch cdl);

    public abstract void logSpeedTime(long speedTime);

    public static long getTime(){
        return System.currentTimeMillis();
    }
}
