package com.ranx.chowder.deepinjvm.jvm9chapter.action;

import java.lang.reflect.Method;

/**
* @Description: 执行工具
* @author ranx
* @date 2019年12月20日14:02:53
 */
public class JavaClassExecuter {

	/**
	 * 执行外部传过来的代表一个Java类的byte数组
	 * 将输入类的byte数组中代表java.lang.System的CONTINUE_Utf8_info常量修改为劫持后的HackSystem类
	 * 执行方法为该类的static main(String[] args)方法，输出结果为该类向System.out/err输出的信息
	 * @param classByte 代表一个java类的byte数组
	 * @return
	 */
	public static String execute(byte[] classByte) {
		HackSystem.clearBuffer();
		ClassModifier cm = new ClassModifier(classByte);
		byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "com/ranx/deepinjvm/jvm9chapter/action/HackSystem");
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class clazz = loader.loadByte(modiBytes);
		
		try {
			Method method = clazz.getMethod("main", new Class[]{ String[].class });
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return HackSystem.getBufferString();
	}
}
