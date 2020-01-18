package com.ranx.chowder.deepinjvm.jvm4chapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @Description: 线程等待演示
* @author ranx
* @date 2019年10月8日18:15:31
 */
public class TdPauseCreate {

	/**
	 * 线程死循环演示
	 */
	public static void createBusyThread() {
		Thread td = new Thread(new Runnable(){
			@Override
			public void run() {
				while (true);
			}
			
		}, "testBusyThread");
		td.start();
	}
	
	/**
	 * 线程锁等待演示
	 */
	public static void createLockThread(final Object lock) {
		Thread td = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}, "testLockThread");
		td.start();
	}
	
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br.readLine();
//		createBusyThread();
//		br.readLine();
//		Object obj = new Object();
//		createLockThread(obj);
		
		
		for (int i=0; i<100; i++) {
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2, 1)).start();
		}
	}
	
	
	/**
	 * 线程死锁等待演示
	 * 
	 */
	static class SynAddRunable implements Runnable{

		int a, b;
		
		public SynAddRunable() {
			super();
		}
		
		public  SynAddRunable(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public void run() {
			synchronized (Integer.valueOf(a)){
				synchronized(Integer.valueOf(b)) {
					System.out.println(a + b);
				}
			}
			
		}
		
	}
}
