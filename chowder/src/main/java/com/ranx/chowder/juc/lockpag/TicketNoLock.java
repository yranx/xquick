package com.ranx.chowder.juc.lockpag;

/**
 * @Description: 
 * @author ranx
 * 2019-8-19上午11:16:39
 */
public class TicketNoLock implements Runnable{

	private  int tick = 100;

	@Override
	public void run() {
		while (true) {
			if (tick > 0) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
				
				System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + --tick);
			}
		}
		
	}
}
