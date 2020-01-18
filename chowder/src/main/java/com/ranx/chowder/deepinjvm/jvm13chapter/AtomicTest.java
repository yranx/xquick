package com.ranx.chowder.deepinjvm.jvm13chapter;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @Description: Atomic的原子自增运算测试
* @author ranx
* @date 2020年1月10日10:59:06
* 比较com.ranx.deepinjvm.jvm12chapter.VolatileTest
* 体会 incrementAndGet() 方法的原子性
*/
public class AtomicTest {
	
	public static AtomicInteger race = new AtomicInteger(0);
	
	public static void increase() {
		race.incrementAndGet();
	}
	
	private static final int THREADS_COUNT = 20;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		for (int i=0; i<THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i=0; i<10000; i++) {
						increase();
					}
				}
				
			});
			threads[i].start();
		}
		
		//等待所有累加线程都结束
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		
		System.out.println(race);
	}
}
