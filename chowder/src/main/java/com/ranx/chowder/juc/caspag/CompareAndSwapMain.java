package com.ranx.chowder.juc.caspag;

public class CompareAndSwapMain {

	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();
		
		for (int i=0; i<10; i++) {
			new Thread(new Runnable(){

				@Override
				public void run() {
					int expectedValue = cas.get();
					boolean b = cas.compareAndSet(expectedValue, (int)(Math.random()*100));
					System.out.println(b);
					
				}
				
			}).start();
		}
	}
}
