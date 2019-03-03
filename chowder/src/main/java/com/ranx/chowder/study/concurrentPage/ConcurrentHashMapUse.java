package com.ranx.chowder.study.concurrentPage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @author ranx
 * @date 2018年12月7日 下午2:21:54
 *
 */
public class ConcurrentHashMapUse {

	public static void HashMapOper() {

		Map<Long, String> mReqPacket = new HashMap<Long, String>();
		for (long i = 0; i < 15; i++) {
			mReqPacket.put(i, i + "");
		}

		// HashMap或者ArrayList边遍历边删除数据会报java.util.ConcurrentModificationException异常
//		for (Entry<Long, String> entry : mReqPacket.entrySet()) {
//			long key = entry.getKey();
//			String value = entry.getValue();
//			if (key < 10) {
//				mReqPacket.remove(key);
//			}
//		}

		for (Iterator<Entry<Long, String>> iterator = mReqPacket.entrySet().iterator(); iterator.hasNext();) {
			Entry<Long, String> entry = iterator.next();
			long key = entry.getKey();
			if (key < 10) {
				iterator.remove();
			}
		}

		for (Entry<Long, String> entry : mReqPacket.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	/**
	 * 对ConcurrentHashMap边遍历边删除或者增加操作不会产生异常(可以不用迭代方式删除元素)，因为其内部已经做了维护，遍历的时候都能获得最新的值。
	 * 即便是多个线程一起删除、添加元素也没问题。
	 */
	public static void ConcurrentHashMapOper() {

		Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
		for (long i = 0; i < 15; i++) {
			conMap.put(i, i + "");
		}

		for (Entry<Long, String> entry : conMap.entrySet()) {
			long key = entry.getKey();
			if (key < 10) {
				conMap.remove(key);
			}
		}

		for (Entry<Long, String> entry : conMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	/**
	 * 一个线程对ConcurrentHashMap增加数据，另外一个线程在遍历时就能获得
	 */
	private static Map<Long, String> consMap = new ConcurrentHashMap<Long, String>();

	public static void ConHashMapOperThread() {

		for (long i = 0; i < 15; i++) {
			consMap.put(i, i + "");
		}

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				consMap.put((long) 1001, "100");
				System.out.println("ADD: " + 100);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (Iterator<Entry<Long, String>> iterator = consMap.entrySet().iterator(); iterator.hasNext();) {
					Entry<Long, String> entry = iterator.next();
					System.out.println(entry.getKey() + " - " + entry.getValue());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		thread.start();
		thread2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------------------------------------------------------");
		for (Entry<Long, String> entry : consMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static void main(String[] args) {
//		HashMapOper();
//		ConcurrentHashMapOper();
		ConHashMapOperThread();
	}

}
