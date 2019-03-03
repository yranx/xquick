package com.ranx.chowder.study.thread;

/**
 * @Description 
 * @author ranx
 * @date 2018年12月19日 上午11:21:50
 *
 */
public class ThreadShutdown {

	private static class MyRunnable implements Runnable{
		private long i;
		private volatile boolean on =true;
		@Override
		public void run() {
			while(on && !Thread.currentThread().isInterrupted()) {
				i++;
				System.out.println(Thread.currentThread()+"Count i = " + i);
			}
//			System.out.println(Thread.currentThread()+"Count i = " + i);
		}
		
		public void cancel() {
			on = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//中断方式
		MyRunnable mrOne = new MyRunnable();
		Thread countT = new Thread(mrOne, "countT");
		countT.start();
		Thread.sleep(1*1000); //  睡眠1秒，main线程对CountT进行中断，使CountT能够感知中断而结束
		countT.interrupt();
	
		//标识位方式
		MyRunnable mrTwo = new MyRunnable();
		countT = new Thread(mrTwo, "countT");
		countT.start();
		Thread.sleep(1*1000); //  睡眠1秒，main线程对CountT进行取消，使CountT能够感知on为false而结束
		mrTwo.cancel();
	}
}
