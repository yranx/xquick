package com.ranx.chowder.deepinjvm.jvm12chapter;


/**
* @Description: volatile变脸自增运算测试
* @author ranx
* @date 2020年1月3日09:04:23
* 20个线程，每个对race自增10000次，结果应为20 0000；
* 但每次结果都小于 200000
* 没保证 原子性
*/
public class VolatileTest {

	public static volatile int race = 0;
	
	public static void increase() {
		race++;
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
