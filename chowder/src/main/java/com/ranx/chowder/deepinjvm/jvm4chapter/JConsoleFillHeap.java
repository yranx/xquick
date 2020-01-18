package com.ranx.chowder.deepinjvm.jvm4chapter;

import java.util.ArrayList;
import java.util.List;

/**
* @Description: JConsole监视代码
以64kb/50ms的速度往java堆中填充数据1000次
* @author ranx
* @date 2019年9月29日16:08:40
 */
public class JConsoleFillHeap {

	/**
	 * 内存占位符对象
	 */
	static class OOMObject {
		public byte[] placeholder = new byte[64 * 1024];
	}
	
	/**
	 * 
	 * VM args: -Xms100M -Xmx100M -XX:+UseSerialGC
	 */
	public static void fillHeap(int num) throws Exception {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i=0; i<num; i++) {
			//稍作延时，让监视曲线的变化更加明显
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
	
	public static void main(String[] args) throws Exception {
		fillHeap(1000);
	}
}
