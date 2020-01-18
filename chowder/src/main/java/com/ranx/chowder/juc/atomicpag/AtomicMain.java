package com.ranx.chowder.juc.atomicpag;

/**
 * @Description: 自增， 原子性
 * @author ranx
 * 2019-8-12下午3:43:14
 */
public class AtomicMain {

	public static void main(String[] args) {
		tdNoAtomic();
//		tdAtomic();
	}
	
	/**
	 * 线程安全问题
	 */
	public static void tdNoAtomic(){
		ThreadDemo ad = new ThreadDemo();
		for (int i=0; i<10; i++) {
			new Thread(ad).start();
		}
	}
	
	/**
	 * 使用原子变量
	 */
	public static void tdAtomic(){
		TdAtomicDemo ad = new TdAtomicDemo();
		for (int i=0; i<10; i++) {
			new Thread(ad).start();
		}
	}

}
