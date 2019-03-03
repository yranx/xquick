package com.ranx.chowder.study.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @author ranx
 * @date 2018年12月17日 下午4:15:13
 *
 */
public class ThreadGroupTest {
	public static class MyRunnable implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " .......... " + i);
			}

		}

	}

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("new threadCroup"); // 创建新的线程组
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr, "t1  Thread");
		Thread t2 = new Thread(tg, mr, "t2  Thread"); // 将线程t2放在组中
		t1.start();
		t2.start();

		System.out.println(t1.getThreadGroup().getName()); // 获取组名
		System.out.println(t2.getThreadGroup().getName());
		System.out.println("Number of Threads : " + tg.activeCount()); // 获取线程个数
		System.out.println("Information about the Thread Group:");
		tg.list(); //查看ThreadGroup信息
		
		Thread[] threads = new Thread[tg.activeCount()];
		tg.enumerate(threads); //复制该线程组及其子组中的所有活动线程到指定的数组
		for (int i = 0; i < tg.activeCount(); i++) {
			System.out.println(i + "=======" +threads[i].getName() + "--------" + threads[i].getState());
		}
		// 通过组名称设置后台线程，表示该组的线程都是后台线程
		tg.setDaemon(true);
	}

}
