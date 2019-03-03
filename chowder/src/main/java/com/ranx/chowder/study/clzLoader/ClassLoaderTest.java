package com.ranx.chowder.study.clzLoader;

/**
 * @Description 
 * @author ranx
 * @date 2018年12月19日 下午4:26:47
 *
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader);
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
	}
}
