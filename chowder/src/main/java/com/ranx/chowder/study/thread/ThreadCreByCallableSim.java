package com.ranx.chowder.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description 多线程的实现之三：实现 Callable 接口和 Future 接口 （有点像Runnable的增强版）
 * @author ranx
 * @date 2018年12月7日 下午3:13:39
 *
 *创建Callable实现类与创建Runnable实现类并没有太大的差别，只是Callable的call()方法允许声明抛出异常， 而且允许带返回值。
 *
 */
public class ThreadCreByCallableSim {
	//实现 Callable 接口，并实现call()方法，作为线程执行体
	public static class MyThread implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {

			return 1;
		}
		
	}
	
	public static void main(String[] args) {
		// 创建Callable对象
		MyThread myThread = new MyThread();
		// 使用FutureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<Integer>(myThread);
		

				new Thread(task, "New Thread").start();

		
		try{
            // 获取线程返回值
            System.out.println("callable返回值：" + task.get());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
	}
}
