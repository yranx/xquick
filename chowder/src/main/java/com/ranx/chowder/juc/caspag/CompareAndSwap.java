package com.ranx.chowder.juc.caspag;

/**
 * @Description: 模拟CAS算法
 * CAS 包含了三个操作数:
	需要读写的内存值: V
	进行比较的预估值: A
	拟写入的更新值: B
当且仅当 V == A 时, V = B, 否则,将不做任何操作;
 * @author ranx
 * 2019-8-12下午4:31:29
 */
public class CompareAndSwap {
	private int value;
	
	//获取内存值
	public synchronized int get() {
		return value;
	}
	
	//无论更新成功与否，都返回修改之前的内存值
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		//内存值 = 预估值
		if (oldValue == expectedValue) {
			//内存值 = 更新值
			this.value = newValue;
		}
		return oldValue;
	}
	
	//设置是否设置成功
	public synchronized boolean compareAndSet(int exceptedValue, int newValue) {
		//预估值 = 更新值
		return exceptedValue == compareAndSwap(exceptedValue, newValue);
		
	}
}
