package com.ranx.chowder.juc.rwlockpag;

/**
 * @Description:
 * @author ranx
 * 2019-8-19下午2:37:26
 */
public class ReadWriterMain {

	public static void main(String[] args) {
		final ReadWriterLockDemo rwl = new ReadWriterLockDemo();
		
		//一个线程写
		new Thread(new Runnable(){
			@Override
			public void run() {
				rwl.set((int)(Math.random()*100));
			}
			
		},"Write:").start();
		
		//100个进程读
		for (int i=0; i<100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					rwl.get();
					
				}
			}, "Read:"+i).start();
		}
	}
}
