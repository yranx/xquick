package com.ranx.chowder.study.clzLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Description 
 * @author ranx
 * @date 2018年12月20日 上午10:55:01
 *
 */
public class UserDefClassLoader extends ClassLoader{
	private String root;
		
	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("UserDef Class Loading!");
		byte[] classData = loadClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}
	
	private byte[] loadClassData(String className) {
		String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
		
		try {
			InputStream ins = new FileInputStream(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = 0;
			while ((length = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserDefClassLoader classLoader = new UserDefClassLoader();
		classLoader.setRoot("D:\\logs\\temp");
		
		Class<?> testClass = null;
		try {
			//传递类的全限定性名称,因为 defineClass 方法是按这种格式进行处理的。
			testClass = classLoader.loadClass("com.ranx.demo.Test");
			Object object = testClass.newInstance();
			System.out.println(object.getClass().getClassLoader());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
