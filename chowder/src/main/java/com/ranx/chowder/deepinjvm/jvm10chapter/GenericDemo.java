package com.ranx.chowder.deepinjvm.jvm10chapter;

import java.util.HashMap;
import java.util.Map;

/**
* @Description: 泛型擦除
* @author ranx
* @date 2019年12月23日17:33:09
 */
public class GenericDemo {

	public static void main(String[] args) {
		/**
		 * 泛型擦除前
		 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello", "你好");
		map.put("how are you?", "吃了没？");
		System.out.println(map.get("hello"));
		System.out.println(map.get("how are you?"));
		
		/**
		 * 泛型擦除后
		 * 编译为class文件，再反编译，会发现泛型都不见了，变回泛型出现前的写法
		 */
//		Map map = new HashMap();
//		map.put("hello", "你好");
//		map.put("how are you?", "吃了没？");
//		System.out.println((String)map.get("hello"));
//		System.out.println((String)map.get("how are you?"));
	}
}
