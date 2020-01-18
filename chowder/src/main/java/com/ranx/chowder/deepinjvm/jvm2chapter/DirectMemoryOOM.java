package com.ranx.chowder.deepinjvm.jvm2chapter;

import java.lang.reflect.Field;

/**
* @Description: 使用unsafe分配本机内存
* @author ranx
* @date 2019年9月26日16:28:02
 */
public class DirectMemoryOOM {

	private static final int _1MB = 1024 * 1024;
	
	/**
	 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
	 */
	public static void main(String[] args) {
//		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//		unsafeField.setAccessible(true);
//		Unsafe unsafe = (Unsafe) unsafeField.get(null);
//		while (true) {
//			unsafe.allocateMemory(_1MB);
//		}
	}
}
