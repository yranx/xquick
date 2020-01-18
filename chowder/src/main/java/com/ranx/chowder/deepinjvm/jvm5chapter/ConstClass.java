package com.ranx.chowder.deepinjvm.jvm5chapter;

/**
* @Description: 被动使用类字段演示
* 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
* @author ranx
* @date 2019年11月12日18:45:29
 */
public class ConstClass {

	static {
		System.out.println("ConstClass init!");
	}
	
	public static final String HELLO_WORLD = "hello world";
}
