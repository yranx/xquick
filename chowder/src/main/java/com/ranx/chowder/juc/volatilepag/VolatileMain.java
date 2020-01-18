package com.ranx.chowder.juc.volatilepag;

/**
 * @Description: 内存可见性问题：当多个线程操作共享数据时，彼此不可见
 * @author ranx
 * 2019-8-12下午2:03:13
 */
public class VolatileMain {
	/**
	 * flag=false位于主存中,[线程1独立缓存]线程1去读取数据并修改为flag=true; 
	 * 这时[main线程独立缓存]main线程去取数据还是flag=false
	 */
	
	public static void main(String[] args) {
//		tdNoVolatile();
//		tdSynchronized();
		tdVolatile();
	}
	
	/**
	 * 未使用volatile之前
	 * 结果：flag=true
	 */
	public static void tdNoVolatile() {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		
		while(true) {
			if (td.isFlag()) {
				System.out.println("########");
				break;
			}
		}
	}
	
	/**
	 * 解决方式一：同步锁
	 * 效率低
	 * 结果：  flag=true
			 ########
	 */
	public static void tdSynchronized() {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		
		while(true) {
			//使用同步锁
			synchronized(td) {
				if (td.isFlag()) {
					System.out.println("########");
					break;
				}
			}
		}
	}
	
	/**
	 * 解决方式二： 使用volatile关键字
	 * 结果：########
			flag=true
	 */
	public static void tdVolatile() {
		TdVolatileDemo td = new TdVolatileDemo();
		new Thread(td).start();
		
		while(true) {
			if (td.isFlag()) {
				System.out.println("########");
				break;
			}
		}
	}
}
