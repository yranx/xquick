package com.ranx.chowder.deepinjvm.jvm8chapter;

/**
* @Description: 方法静态分派演示
* @author ranx
* @date 2019年12月18日16:51:41
 */
public class StaticDispatch {

	static abstract class Human{}
	static class Man extends Human{}
	static class Woman extends Human{}
	
	public void sayHello(Human guy){
		System.out.println("hello, guy!");
	}
	public void sayHello(Man guy){
		System.out.println("hello, gentleman!");
	}
	public void sayHello(Woman guy){
		System.out.println("hello, lady!");
	}
	
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch sr = new StaticDispatch();
		sr.sayHello(man);
		sr.sayHello(woman);
	}
}
