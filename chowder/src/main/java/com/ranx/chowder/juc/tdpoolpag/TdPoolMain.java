package com.ranx.chowder.juc.tdpoolpag;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description:线程池
 * @author ranx
 * 2019-8-23上午10:32:05
 */
public class TdPoolMain {
	public static void main(String[] args) throws Exception {
//		createPool();
		scheduledPool();
	}
	
	public static void createPool() {
		//1.创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
		ThreadPoolDemo tpd = new ThreadPoolDemo();
		
		//2.为线程池中线程分配任务
		for (int i=0; i<10; i++) {
			pool.submit(tpd);
		}
		
		//3.关闭线程池
		pool.shutdown();
	}
	
	public static void scheduledPool() throws Exception {
		//1.创建线程池
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		
		//2.分配任务
		for (int i=0; i<10; i++) {
			Future<Integer> result = pool.schedule(new Callable<Integer>(){
				public Integer call() throws Exception{
					int num = new Random().nextInt(100);
					System.out.println(Thread.currentThread().getName() + ":" + num);
					return num;
				}
			}, 3, TimeUnit.SECONDS);
			
			System.out.println(result.get());
		}
		
		//3.关闭线程池
		pool.shutdown();
	}
}
