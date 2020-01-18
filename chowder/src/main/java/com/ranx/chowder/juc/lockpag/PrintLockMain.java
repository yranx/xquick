package com.ranx.chowder.juc.lockpag;

/**
 * @Description: 开启三线程A、B、C打印十遍各自ID(A/B/C)
 * @author ranx
 * 2019-8-19下午1:44:25
 */
public class PrintLockMain {
	public static void main(String[] args) {
		final PrintLockAlternate pla = new PrintLockAlternate();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1; i<20; i++) {
					pla.loopA(i);
				}
			}
		}, "A").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1; i<20; i++) {
					pla.loopB(i);
				}
			}
		}, "B").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=1; i<20; i++) {
					pla.loopC(i);
				}
			}
		}, "C").start();
	}
}
