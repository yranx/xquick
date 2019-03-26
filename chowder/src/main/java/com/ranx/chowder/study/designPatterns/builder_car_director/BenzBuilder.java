package com.ranx.chowder.study.designPatterns.builder_car_director;

import java.util.ArrayList;

/**
 * @Description: 奔驰车组装者
 * 给定一个汽车运行程序，就返回一个奔驰车
 * @author ranx
 * @date 2019-3-20-下午4:30:49

 */
public class BenzBuilder extends CarBuilder {

	private BenzModel benz = new BenzModel();
	
	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.benz.setSequence(sequence);
	}


	@Override
	public CarModel getCarModel() {
		return this.benz;
	}

}
