package com.ranx.chowder.clzLoader;

import com.ranx.chowder.thread.ThreadShutdown;

/**
 * @Description
 * @author ranx
 * @date 2018年12月19日 下午5:10:11
 *
 */
public class LoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = ThreadShutdown.class.getClassLoader();
		System.out.println(loader);
		//使用ClassLoader.loadClass()来加载类，不会初始化块
		loader.loadClass("com.ranx.chowder.clzLoader.Test");
		//使用Class.forName()来加载类，默认会执行初始化块
//		Class.forName("com.ranx.demo.Test");
		//使用Class.forName()来加载类,并指定ClassLoader,初始化时不执行静态块
//		Class.forName("com.ranx.demo.Test", false ,loader);
	}
}
