package com.ranx.chowder.deepinjvm.jvm2chapter;

import java.util.ArrayList;
import java.util.List;

/**
* @Description: java堆溢出
* @author ranx
* @date 2019年9月25日17:19:08
 */
public class HeapOOM {

	static class OOMObject{}
	
	/**
	 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
	 * 
	 */
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
