package com.ranx.chowder.deepinjvm.jvm2chapter;


/**
* @Description: 虚拟机栈和本地方法栈OOM测试
* @author ranx
* @date 2019年9月26日15:02:09
 */
public class JavaVMStackSOF {
	private int stackLength = 1;
	
	/**
	 * VM Args:-Xss128k 
	 * 
	 */
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack length:" + oom.stackLength);
			throw e;
		}
	}
}
