package com.ranx.chowder.juc.lockpag;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author ranx
 * 2019-8-19上午11:19:14
 */
public class TicketLock implements Runnable{

	private int tick = 100;
	
	private Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while (true) {
			lock.lock();
			
			try {
				if (tick > 0) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {

					}
					System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + --tick);
				}
			} finally {
				//释放锁
				lock.unlock();
			}
		}
	}
}
