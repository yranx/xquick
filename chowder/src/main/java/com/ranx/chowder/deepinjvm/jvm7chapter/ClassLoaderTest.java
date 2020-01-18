package com.ranx.chowder.deepinjvm.jvm7chapter;

import java.io.InputStream;

/**
* @Description: 不同的类加载器加载的相同的类，必定不相等
* 类加载器与instanceof关键字
* @author ranx
* @date 2019年12月9日14:11:10
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {

			/**
			 * 加载同一路径下的Class文件
			 */
			@Override
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (Exception e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		
		Object obj = myLoader.loadClass("com.ranx.deepinjvm.jvm7chapter.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.ranx.chowder.deepinjvm.jvm7chapter.ClassLoaderTest);
	}
}
