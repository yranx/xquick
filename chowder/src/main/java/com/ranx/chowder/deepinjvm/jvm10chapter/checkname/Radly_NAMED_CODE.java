package com.ranx.chowder.deepinjvm.jvm10chapter.checkname;

/**
* @Description: 包含多出不规范命名的代码样例
* @author ranx
* @date 2019年12月26日16:56:05
 */
public class Radly_NAMED_CODE {

	enum colors {
		red,
		blue,
		green;
	}
	
	static final int _FORTY_TWO = 42;
	
	public static int NOT_A_CONSTANT = _FORTY_TWO;
	
	protected void REDLY_NAMED_CODE() {
		return;
	}
	
	public void NOTcamelCASEmethodNAME() {
		return;
	}
}
