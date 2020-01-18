package com.ranx.chowder.deepinjvm.jvm8chapter;


/**
* @Description: 方法动态分派演示
* @author ranx
* @date 2019年12月18日16:51:41
 */
public class DynamicDispatch {
	static abstract class Human{
		protected abstract void sayHello();
	}
	
	static class Man extends Human{

		@Override
		protected void sayHello() {
			System.out.println("hello, gentleman!");
		}
	}
	static class Woman extends Human{

		@Override
		protected void sayHello() {
			System.out.println("hello, lady!");
		}
	}
	

	
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		man.sayHello();
		woman.sayHello();
		man = new Woman();
		man.sayHello();
		
	}
}
