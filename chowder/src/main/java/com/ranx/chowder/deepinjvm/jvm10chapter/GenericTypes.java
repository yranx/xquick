package com.ranx.chowder.deepinjvm.jvm10chapter;

import java.util.List;

/**
* @Description: 泛型&&重载
* @author ranx
* @date 2019年12月23日16:13:09
 */
public class GenericTypes {

	/**
	 * 无法重载的原因：参数List<String>和List<Integer>编译后被擦除，变成一样的原生类型List<E>,
	 * 擦除动作导致这两种方法的特征签名变得一模一样
	 * 
	 */
//	public static void method(List<String> list) {
//		System.out.println("invoke method(List<String) list)");
//	}
//	public static void method(List<Integer> list) {
//		System.out.println("invoke method(List<Integer) list)");
//	}
	
	
//	public static String method(List<String> list) {
//		System.out.println("invoke method(List<String) list)");
//		return "";
//	}
//	public static int method(List<Integer> list) {
//		System.out.println("invoke method(List<Integer) list)");
//		return 1;
//	}
}
