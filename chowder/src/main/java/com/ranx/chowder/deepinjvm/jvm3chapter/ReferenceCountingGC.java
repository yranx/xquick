package com.ranx.chowder.deepinjvm.jvm3chapter;

/**
* @Description: 引用计数算法的缺陷
* @author ranx
* @date 2019年9月27日10:08:28
 */
public class ReferenceCountingGC {
	public Object instance = null;
	
	private static final int _1MB = 1024 * 1024;
	
	//占内存，以便能在GC日志中看清楚是否被回收过
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		//假设发生GC
		System.gc();
		System.out.println("over");
	}
	
	public static void main(String[] args) {
		testGC();
	}
}
