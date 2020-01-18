package com.ranx.chowder.juc.atomicpag;

import java.util.concurrent.atomic.AtomicInteger;

public class TdAtomicDemo implements Runnable{
	private AtomicInteger serialNumber = new AtomicInteger();

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println(Thread.currentThread().getName() 
				+ ":" + getSerialNumber());
	}

	public int getSerialNumber() {
		//自增运算
		return serialNumber.getAndIncrement();
	}
}
