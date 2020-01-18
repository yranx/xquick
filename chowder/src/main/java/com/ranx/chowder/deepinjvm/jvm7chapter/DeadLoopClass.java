package com.ranx.chowder.deepinjvm.jvm7chapter;

/**
* @Description: 多个线程初始化一个类，只会有一个线程去执行这个类的<clinit>()方法，其他线程需堵塞
* @author ranx
* @date 2019年12月9日14:11:10
 */
public class DeadLoopClass {
	static {
		if (true) {
			System.out.println(Thread.currentThread() + "init DeadLoopClass");
			while (true) {}
		}
	}
	
	public static void main(String[] args) {
		Runnable script = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread() + "start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread() + "run over");
			}
		};
		
		Thread t1 = new Thread(script);
		Thread t2 = new Thread(script);
		t1.start();
		t2.start();
	}
}
