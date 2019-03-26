package com.ranx.chowder.study.designPatterns.builder_car1;

/**
 * @Description: 奔驰车模型
 * @author ranx
 * @date 2019-3-20-下午3:55:15

 */
public class BenzModel extends CarModel {


	@Override
	protected void start() {
		System.out.println("奔驰车跑动...");
	}


	@Override
	protected void stop() {
		System.out.println("奔驰车停车...");
	}


	@Override
	protected void alarm() {
		System.out.println("奔驰车的喇叭声音...");

	}


	@Override
	protected void engineBoom() {
		System.out.println("奔驰车引擎声...");
	}

}
