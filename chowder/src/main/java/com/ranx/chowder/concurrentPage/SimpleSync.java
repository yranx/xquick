package com.ranx.chowder.concurrentPage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 异步
 * @author ranx
 * @date 2018年11月16日 上午11:31:32
 *
 */
public class SimpleSync {

	// 可容纳10个线程的执行器
	//TODO 改造下
	final static ExecutorService EXEC = Executors.newFixedThreadPool(10);

	public static class SimpleRunner implements Runnable {
		int runIndex = 0;

		public SimpleRunner(int runIndex) {
			super();
			this.runIndex = runIndex;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			try {
				// 3秒内随机结束
				Thread.sleep((long) (Math.random() * 3000));
				System.out.println(runIndex + "...Run");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 运行结果发现main线程早就先跑完了
	 */
	public static void main(String[] args) {
		System.out.println("Start!!!");

		// 并行跑10个线程
		for (int i = 0; i < 10; i++) {
			SimpleRunner runner = new SimpleRunner(i);
			EXEC.submit(runner);
		}

		// 关闭
		EXEC.shutdown();
		System.out.println("End!!!");
	}
}
