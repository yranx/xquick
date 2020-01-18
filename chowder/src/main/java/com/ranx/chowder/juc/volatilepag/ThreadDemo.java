package com.ranx.chowder.juc.volatilepag;

/**
 * @Description: 
 * @author ranx
 * 2019-8-12下午1:57:43
 */
public class ThreadDemo implements Runnable{

	private boolean flag = false;
	
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();		
		}
		
		flag = true;
		System.out.println("flag=" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
