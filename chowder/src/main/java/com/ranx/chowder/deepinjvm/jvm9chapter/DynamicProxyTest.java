package com.ranx.chowder.deepinjvm.jvm9chapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
* @Description: 动态代理的简单示例
* @author ranx
* @date 2019年12月19日17:01:54
 */
public class DynamicProxyTest {

	interface IHello {
		void sayHello();
	}
	
	static class Hello implements IHello {
		@Override
		public void sayHello() {
			System.out.println("hello world");
			
		}
	}
	
	static class DynamicProxy implements InvocationHandler {
		Object originalObj;
		Object bind(Object originalObj) {
			this.originalObj = originalObj;                         
			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), 
					originalObj.getClass().getInterfaces(),
					this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("Welcome");
			return method.invoke(originalObj, args);
		}
	}
	
	public static void main (String[] args) {
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();
	}
}
