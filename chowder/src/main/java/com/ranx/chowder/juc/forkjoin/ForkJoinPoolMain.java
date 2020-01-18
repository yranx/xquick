package com.ranx.chowder.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolMain {
 
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		
		ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 10000000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		pool.shutdown();
	}
}
