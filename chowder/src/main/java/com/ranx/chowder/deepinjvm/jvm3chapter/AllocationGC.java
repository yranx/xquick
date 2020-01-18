package com.ranx.chowder.deepinjvm.jvm3chapter;

/**
* @Description: 内存分配与回收策略
* @author ranx
* @date 2019年9月29日09:50:30
 */
public class AllocationGC {

	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) {
//		testAllocation();
//		testPretenureSizeThreshold();
//		testTenuringThreshold();
//		testTenuringThreshold2();
		testHandlePromotion();
	}
	
	
	/**
	 * VM: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	public static void testAllocation() {
		byte[] act1,act2,act3,act4;
		act1 = new byte[2 * _1MB];
		act2 = new byte[2 * _1MB];
		act3 = new byte[2 * _1MB];
		act4 = new byte[2 * _1MB];
		
	}
	
	/**
	 * VM: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
	 */
	public static void testPretenureSizeThreshold() {
		byte[] act;
		act = new byte[4 * _1MB]; //直接分配在老年代中
	}

	/**
	 * VM: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold() {
		byte[] act1,act2,act3;
		act1 = new byte[_1MB / 4];
		act2 = new byte[4 * _1MB];
		act3 = new byte[4 * _1MB];
		act3 = null;
		act3 = new byte[4 * _1MB];
		
	}
	
	/**
	 * VM: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2() {
		byte[] act1,act2,act3,act4;
		act1 = new byte[_1MB / 4];
		act2 = new byte[_1MB / 4];
		act3 = new byte[4 * _1MB];
		act4 = new byte[4 * _1MB];
		act4 = null;
		act4 = new byte[4 * _1MB];
		
	}
	
	/**
	 * VM: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
	 */
	@SuppressWarnings("unused")
	public static void testHandlePromotion() {
		byte[] act1,act2,act3,act4,act5,act6,act7;
		act1 = new byte[2 * _1MB];
		act2 = new byte[2 * _1MB];
		act3 = new byte[2 * _1MB];
		act1 = null;
		act4 = new byte[2 * _1MB];
		act5 = new byte[2 * _1MB];
		act6 = new byte[2 * _1MB];
		act4 = null;
		act5 = null;
		act6 = null;
		act7 = new byte[2 * _1MB];
	}
}
