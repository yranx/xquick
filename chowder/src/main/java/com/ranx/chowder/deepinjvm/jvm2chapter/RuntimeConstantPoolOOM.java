package com.ranx.chowder.deepinjvm.jvm2chapter;

import java.util.ArrayList;
import java.util.List;


/**
* @Description: 运行时常量池导致的内存溢出异常
* @author ranx
* @date 2019年9月26日15:28:40
 */
public class RuntimeConstantPoolOOM {
	

	public static void main(String[] args) throws Throwable{
//		constantList();
		constantString();
	}
	
	/**
	 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
	 */
	
	/**
	 * JDK1.7将一直循环下去
	 * 
	 */
	public static void constantList() {
		//使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
			System.out.println(i);
		}
	}
	
	public static void constantString() {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
	
	
	
	
	
	
	
	
	
	
	
}
