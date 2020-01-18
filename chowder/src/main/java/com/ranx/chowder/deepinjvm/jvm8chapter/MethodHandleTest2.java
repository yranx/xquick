package com.ranx.chowder.deepinjvm.jvm8chapter;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
* @Description:  MethodHandle
* @author ranx
* @date 2019年12月19日16:51:41
 */
public class MethodHandleTest2 {

	class GrandFather {
		void thinking() {
			System.out.println("i am grandfather");
		}
	}
	
	class Father extends GrandFather {
		void thinking () {
			System.out.println("i am father");
		}
	}
	
	class Son extends Father {
		void thinking() {
			
			//实现调用祖父类的thinking()方法
			MethodType mt = MethodType.methodType(void.class);
			try {
				MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
				mh.invoke(this);
			} catch (Throwable e) {

			}
		}
	}
	public static void main(String[] args) {
		(new MethodHandleTest2().new Son()).thinking();
		/**
		 * i am father
		 * 并没有实现
		 */
	}
}
