package com.ranx.chowder.thread;

/**
 * @Description 
 * @author ranx
 * @date 2018年12月7日 上午9:29:51
 *
 */
public class ThreadLocalDemo {
	private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<Object>() {

		/**
		 * ThreadLocal没有被当前线程赋值时或当前线程刚被调用remove方法后调用get方法，返回此方法
		 */
		@Override
		protected Object initialValue() {
			System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
			return super.initialValue();
//			return null;
		}
		
	};
	
	public static void main(String[] args) {
		new Thread(new IntegerTask("IntegerTask1")).start();
		new Thread(new StringTask("StringTask1")).start();
		new Thread(new IntegerTask("IntegerTask2")).start();
		new Thread(new StringTask("StringTask2")).start();
	}
	
	public static class IntegerTask implements Runnable{
		private String name;

		public IntegerTask(String name) {
			super();
			this.name = name;
		}

		@Override
		public void run() {
			for (int i=0; i<5; i++) {
				//Threadlocal.get方法获取线程变量
				if (null == ThreadLocalDemo.THREAD_LOCAL.get()) {
					//ThreadLocal.set方法设置线程变量
					ThreadLocalDemo.THREAD_LOCAL.set(0);
					System.out.println("线程" + name + ": 0");
				} else {
					int num = (Integer)ThreadLocalDemo.THREAD_LOCAL.get();
					ThreadLocalDemo.THREAD_LOCAL.set(num + 1);
					System.out.println("线程" + name + ": " + ThreadLocalDemo.THREAD_LOCAL.get());
					if (i == 3) {
						ThreadLocalDemo.THREAD_LOCAL.remove();
					}
				}
				
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
	}
	
	
	public static class StringTask implements Runnable{
		private String name;

		public StringTask(String name) {
			super();
			this.name = name;
		}

		@Override
		public void run() {
			for (int i=0; i<5; i++) {
				//Threadlocal.get方法获取线程变量
				if (null == ThreadLocalDemo.THREAD_LOCAL.get()) {
					ThreadLocalDemo.THREAD_LOCAL.set("a");
					System.out.println("线程" + name + ": a");
				} else {
					String str = (String)ThreadLocalDemo.THREAD_LOCAL.get();
					ThreadLocalDemo.THREAD_LOCAL.set(str + "a");
					System.out.println("线程" + name + ": " + ThreadLocalDemo.THREAD_LOCAL.get());
				}
				
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}
	
}
