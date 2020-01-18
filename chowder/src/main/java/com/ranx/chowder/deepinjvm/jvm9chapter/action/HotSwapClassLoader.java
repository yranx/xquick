package com.ranx.chowder.deepinjvm.jvm9chapter.action;


/**
* @Description: 同一个类的代码可以被多次加载
* 为了多次载入执行类而加入的加载器
* 把defineClass方法开放出来，只有外部显式调用的时候才会使用到loadByte方法
* 由虚拟机调用时，仍然需要按照原有的双亲委派规则使用loadClass方法进行类加载
* @author ranx
* @date 2019年12月19日17:01:54
 */
public class HotSwapClassLoader extends ClassLoader{

	/**
	 * 指定为加载HotSwapClassLoader类的类加载器作为父类加载器
	 */
	public HotSwapClassLoader() {
		super(HotSwapClassLoader.class.getClassLoader());
	}
	
	/**
	 * 公开父类中的protected方法defineClass(),
	 * 把提交执行的java类的byte[]数组转变为Class对象
	 * @param classByte
	 * @return
	 */
	public Class loadByte(byte[] classByte) {
		return defineClass(null, classByte, 0, classByte.length);
	}
}
