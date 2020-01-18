package com.ranx.chowder.juc.rwlockpag;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: ReadWriterLock 读写锁
 * 写写/读写 需要“互斥”
 * 读读不需要互斥
 * @author ranx
 * 2019-8-19下午2:19:15
 */
public class ReadWriterLockDemo {
	private int number = 0;
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	//读
	public void get() {
		//上锁
		lock.readLock().lock();
		
		try {
			System.out.println(Thread.currentThread().getName() + ":" + number);
		} finally {
			lock.readLock().unlock();
		}
	}
	
	//写
	public void set(int number) {
		lock.writeLock().lock();
		
		try {
			System.out.println(Thread.currentThread().getName());
			this.number = number;
		} finally {
			lock.writeLock().unlock();
		}
	}
}
