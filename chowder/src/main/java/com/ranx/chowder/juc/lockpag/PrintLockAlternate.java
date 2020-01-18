package com.ranx.chowder.juc.lockpag;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 轮询交替程序
 * @author ranx
 * 2019-8-19上午11:34:00
 */
public class PrintLockAlternate {

	private int number = 1; //当前正在执行线程的标记
	
	private Lock lock = new ReentrantLock();
	private Condition conditionOne = lock.newCondition();
	private Condition conditionTwo = lock.newCondition();
	private Condition conditionThree = lock.newCondition();
	
	//totalLoop 表示循环第几轮
	//线程A
	public void loopA(int totalLoop) {
		//上锁
		lock.lock();
		
		try {
			if (number != 1) {
				conditionOne.await();
			}
			
			for (int i=1; i<=5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t"
						+ i + "\t"
						+ totalLoop);
			}
			
			//唤醒线程2
			number = 2;
			conditionTwo.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			lock.unlock();
		}
	}
	
	//线程B
	public void loopB(int totalLoop) {
		//上锁
		lock.lock();
		
		try {
			if (number != 2) {
				conditionTwo.await();
			}
			
			for (int i=1; i<=15; i++) {
				System.out.println(Thread.currentThread().getName() + "\t"
						+ i + "\t"
						+ totalLoop);
			}
			
			//唤醒线程3
			number = 3;
			conditionThree.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			lock.unlock();
		}
	}
	
	//线程C
	public void loopC(int totalLoop) {
		//上锁
		lock.lock();
		
		try {
			if (number != 3) {
				conditionThree.await();
			}
			
			for (int i=1; i<=20; i++) {
				System.out.println(Thread.currentThread().getName() + "\t"
						+ i + "\t"
						+ totalLoop);
			}
			
			//唤醒线程3
			number = 1;
			conditionOne.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			lock.unlock();
		}
	}
}
