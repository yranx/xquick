package com.ranx.chowder.deepinjvm.jvm4chapter;

import java.util.Map;
/**
* @Description: 服务器线程信息
* @author ranx
* @date 2019年9月29日15:50:30
 */
public class ServerTdInfo {

	public static void main(String[] args) {
		for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
			Thread thread = (Thread) stackTrace.getKey();
			StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
			if (thread.equals(Thread.currentThread())) {
				continue;
			}
			System.out.print("\n线程:"+ thread.getName() + "\n");
			for (StackTraceElement element : stack) {
				System.out.print("\t" + element + "\n");			
			}
		}
	}
}
