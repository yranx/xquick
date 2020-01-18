package com.ranx.chowder.deepinjvm.jvm5chapter;

/**
* @Description: 被动使用类字段演示
* 通过子类引用父类的静态字段，不会导致子类初始化
* @author ranx
* @date 2019年11月12日18:45:29
 */
public class SuperClass {

	static {
		System.out.println("SuperClass init!");
	}
	
	public static int value = 123;
}
