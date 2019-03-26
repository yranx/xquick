package com.ranx.chowder.study.designPatterns.builder_car_director;

import java.util.ArrayList;

/**
 * @Description: 宝马车组装者
 * @author ranx
 * @date 2019-3-20-下午4:35:12

 */
public class BMWBuilder extends CarBuilder {

	private BMWModel bmw = new BMWModel();
	
	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.bmw.setSequence(sequence);
	}

	@Override
	public CarModel getCarModel() {
		return this.bmw;
	}

}
