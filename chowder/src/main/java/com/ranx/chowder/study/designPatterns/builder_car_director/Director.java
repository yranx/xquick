package com.ranx.chowder.study.designPatterns.builder_car_director;

import java.util.ArrayList;

/**
 * @Description: 导演类
 * 负责按照指定的顺序生产模型
 * @author ranx
 * @date 2019-3-20-下午4:59:03

 */
public class Director {
	private ArrayList<String> sequence = new ArrayList();
	private BenzBuilder benzBuilder = new BenzBuilder();
	private BMWBuilder bmwBuilder = new BMWBuilder();
	
	//A类型的奔驰车模型
	public BenzModel getABenzModel() {
		//清理场景
		this.sequence.clear();
		//顺序
		this.sequence.add("start");
		this.sequence.add("stop");
		//按照顺序返回一个奔驰车
		this.benzBuilder.setSequence(this.sequence);
		return (BenzModel) this.benzBuilder.getCarModel();
	}
	
	//B类型的奔驰车模型
	public BenzModel getBBenzModel() {
		//清理场景
		this.sequence.clear();
		//顺序
		this.sequence.add("engine boom");
		this.sequence.add("start");
		this.sequence.add("stop");
		//按照顺序返回一个奔驰车
		this.benzBuilder.setSequence(this.sequence);
		return (BenzModel) this.benzBuilder.getCarModel();
	}
	
	//C类型的宝马模型
	public BMWModel getCBMWModel() {
		//清理场景
		this.sequence.clear();
		//顺序
		this.sequence.add("alarm");
		this.sequence.add("start");
		this.sequence.add("stop");
		//按照顺序返回一个宝马车
		this.bmwBuilder.setSequence(this.sequence);
		return (BMWModel) this.bmwBuilder.getCarModel();
	}
	
	//D类型的宝马模型
	public BMWModel getDBMWModel() {
		//清理场景
		this.sequence.clear();
		//顺序
		this.sequence.add("start");
		//按照顺序返回一个宝马车
		this.bmwBuilder.setSequence(this.sequence);
		return (BMWModel) this.bmwBuilder.getCarModel();
	}
	
	
	//.....................
}
