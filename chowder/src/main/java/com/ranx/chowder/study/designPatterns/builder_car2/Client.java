package com.ranx.chowder.study.designPatterns.builder_car2;

import java.util.ArrayList;

import javax.sound.midi.Sequence;

/**
 * @Description: 
 * @author ranx
 * @date 2019-3-20-下午4:11:51

 */
public class Client {
	
	public static void main(String[] args) {
		//存放顺序
		ArrayList<String> sequence = new ArrayList<String>();
		sequence.add("engine boom");
		sequence.add("start");
		sequence.add("stop");
		//将该顺序赋予奔驰车builder
		BenzBuilder benzBuilder = new BenzBuilder();
		benzBuilder.setSequence(sequence);
		BenzModel benz = (BenzModel)benzBuilder.getCarModel();
		benz.run();
		
		//相同顺序来个宝马
		BMWBuilder bmwBuilder = new BMWBuilder();
		bmwBuilder.setSequence(sequence);
		BMWModel bmw = (BMWModel)bmwBuilder.getCarModel();
		bmw.run();
	}

	
}
