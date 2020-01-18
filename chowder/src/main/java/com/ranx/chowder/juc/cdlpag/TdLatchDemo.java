package com.ranx.chowder.juc.cdlpag;

import java.util.concurrent.CountDownLatch;

public class TdLatchDemo implements Runnable{

	private CountDownLatch latch;

	public TdLatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		synchronized(this) {
			try {
				//打印偶数
				for (int i=0; i<50000; i++) {
					if (i % 2 == 0) {
						System.out.println(i);
					}
				}
			} finally {
				//线程数量递减
				latch.countDown();
			}
		}
	}
	
	
	
}
