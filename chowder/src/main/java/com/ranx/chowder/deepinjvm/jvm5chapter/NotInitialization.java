package com.ranx.chowder.deepinjvm.jvm5chapter;

/**
* @Description: 非主动使用类字段演示
* @author ranx
* @date 2019年10月8日18:15:31
 */
public class NotInitialization {
	public static void main(String[] args) {
		//演示1
//		System.out.println(SubClass.value);
		
		//演示2：通过数组定义来引用类，不会触发类的初始化
//		SuperClass[] sca = new SuperClass[10];
		
		//演示3
		System.out.println(ConstClass.HELLO_WORLD);
	}
}
