package com.ranx.chowder.juc.atomicpag;

public class ThreadDemo implements Runnable {

	private int serialNumber = 0;

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
		return serialNumber++;
	}
	
	
}
