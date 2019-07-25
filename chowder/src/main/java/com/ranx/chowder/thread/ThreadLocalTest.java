package com.ranx.chowder.thread;

/**
 * @Description 
 * @author ranx
 * @date 2018年12月7日 上午10:44:08
 *
 */
public class ThreadLocalTest {

	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
		
		//Test 1
//		@Override
//		public void run() {
//			threadLocal.set((int) (Math.random() * 100D));
//			System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
//		}	
		
		
		/**
		 * MyRunnable的构造函数是由main主线程调用的，所以TheadLocal的set方法，实际上是在main主线程的环境中完成的，
		 * 因此也只能在main主线程中get到，而run方法运行的上下文是子线程本身，由于run方法中并没有使用set方法赋值，
		 * 因此get到的是默认空值null.
		 */
		//Test 2
		public MyRunnable() {
			threadLocal.set((int) (Math.random() * 100D));
			System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
		}	
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
		}

		/**
		 * 必须回收自定义的ThreadLocal变量，尤其在线程池场景下，线程经常会被复用，
		 * 如果不清理自定义的 ThreadLocal变量，可能会影响后续业务逻辑和造成内存泄露等问题。
		 * 尽量在代理中使用try-finally块进行回收。
		 */
		public  void remove(){
			threadLocal.remove();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new MyRunnable(),"A").start();
		new Thread(new MyRunnable(),"B").start();
	}
	
}
