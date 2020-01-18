package com.ranx.chowder.juc.cdlpag;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 计算多线程的执行时间
 * CountDownLatch(闭锁)
 * @author ranx
 * 2019-8-12下午5:11:05
 */
public class CountDownLatchMain {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(10);
		TdLatchDemo ld = new TdLatchDemo(latch);
		
		long start = System.currentTimeMillis();
		//创建10线程
		for (int i=0; i<10; i++) {
			new Thread(ld).start();
		}
		try {
			latch.await();
		} catch (Exception e) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
	}
}
