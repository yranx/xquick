package com.ranx.chowder.designPatterns.builder_car1;

/**
 * @Description: 宝马车模型
 * @author ranx
 * @date 2019-3-20-下午3:55:15

 */
public class BMWModel extends CarModel {


	@Override
	protected void start() {
		System.out.println("宝马跑动...");
	}


	@Override
	protected void stop() {
		System.out.println("宝马停车...");
	}


	@Override
	protected void alarm() {
		System.out.println("宝马的喇叭声音...");

	}


	@Override
	protected void engineBoom() {
		System.out.println("宝马引擎声...");
	}

}
