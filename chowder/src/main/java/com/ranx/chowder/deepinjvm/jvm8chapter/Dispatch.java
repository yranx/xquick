package com.ranx.chowder.deepinjvm.jvm8chapter;

/**
* @Description: 方法动态分派演示
* @author ranx
* @date 2019年12月18日16:51:41
 */
public class Dispatch {

	static class QQ{}
	
	static class _360{}
	
	public static class Father {
		public void hardChoice(QQ arg) {
			System.out.println("father choose qq");
		}
		
		public void hardChoice(_360 arg) {
			System.out.println("father choose 360");
		}
	}
	public static class Son extends Father {
		public void hardChoice(QQ arg) {
			System.out.println("son choose qq");
		}
	
		public void hardChoice(_360 arg) {
			System.out.println("son choose 360");
		}
	}
	
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.hardChoice(new _360());
		son.hardChoice(new QQ());
	}
}
