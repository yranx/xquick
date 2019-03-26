package com.ranx.chowder.study.designPatterns.builder_car_director;

import java.util.ArrayList;

/**
 * @Description: 车辆模型抽象类
 * @author ranx
 * @date 2019-3-17-上午10:24:37

 */
public abstract class CarModel {
	//该参数是各个基本方法执行的顺序
	private ArrayList<String> sequence = new ArrayList<String>();
	
	protected abstract void start();
	
	protected abstract void stop();
	
	protected abstract void alarm();
	
	protected abstract void engineBoom();
	
	final public void run() {
		//循环一遍，谁在前就先执行谁
		for (int i=0; i<this.sequence.size(); i++) {
			String actionName = this.sequence.get(i);
			if ("start".equalsIgnoreCase(actionName)) {
				this.start();
			} else if ("stop".equalsIgnoreCase(actionName)) {
				this.stop();
			} else if ("alarm".equalsIgnoreCase(actionName)) {
				this.alarm();
			} else if ("engine boom".equalsIgnoreCase(actionName)) {
				this.engineBoom();
			}
		}
	}
	
	//把传递过来的值传递到类内
	final public void setSequence(ArrayList<String> sequence) {
		this.sequence = sequence;
	}
}
