package com.ranx.chowder.deepinjvm.jvm3chapter;

/**
* @Description: 一次对象自我拯救
* 1.对象可以在被GC时自我拯救
* 2.这种拯救机会只有一次，因为一个对象的finalize()方法最多会被系统自动调用一次
* @author ranx
* @date 2019年9月27日10:08:28
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive() {
		System.out.println("still alive!");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
	
	public static void saveHook() throws Exception {
		SAVE_HOOK = null;
		System.gc();
		
		//由于finalize方法优先级很低，故暂停0.5s以等待它
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("dead!");
		}
	}
	public static void main(String[] args) throws Exception {
		SAVE_HOOK = new FinalizeEscapeGC();
		
		//对象第一次成功拯救自己
		saveHook();
		//第二次拯救自己失败了
		saveHook();
	}
}
