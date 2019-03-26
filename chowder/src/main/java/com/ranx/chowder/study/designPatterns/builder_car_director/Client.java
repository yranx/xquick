package com.ranx.chowder.study.designPatterns.builder_car_director;

/**
 * @Description: 
 * @author ranx
 * @date 2019-3-20-下午4:11:51

 */
public class Client {
	
	public static void main(String[] args) {
		Director director = new Director();
		//1w辆A类型的奔驰车
		for (int i=0; i<10000; i++) {
			director.getABenzModel().run();
		}
		//100w辆B类型的奔驰车
		for (int i=0; i<1000000; i++) {
			director.getBBenzModel().run();
		}
		//1000w辆C类型的奔驰车
		for (int i=0; i<1000000; i++) {
			director.getCBMWModel().run();
		}
	}

	
}
