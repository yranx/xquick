package com.ranx.chowder.study.designPatterns.builder_car2;

import java.util.ArrayList;

/**
 * @Description: 抽象汽车组装者
 * @author ranx
 * @date 2019-3-20-下午4:24:42

 */
public abstract class CarBuilder {
	//组装顺序
	public abstract void setSequence(ArrayList<String> sequence);
	
	//获取该车辆模型
	public abstract CarModel getCarModel();
}
