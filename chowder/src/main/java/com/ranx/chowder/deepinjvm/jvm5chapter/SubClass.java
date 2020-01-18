package com.ranx.chowder.deepinjvm.jvm5chapter;

/**
* @Description: 被动使用类字段演示
* @author ranx
* @date 2019年11月12日18:48:08
 */
public class SubClass extends SuperClass{

	static {
		System.out.println("SubClass init!");
	}
	
}
