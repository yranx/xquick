package com.ranx.chowder.designPatterns.builder_car1;

import java.util.ArrayList;

import javax.sound.midi.Sequence;

/**
 * @Description: 
 * @author ranx
 * @date 2019-3-20-下午4:11:51

 */
public class Client {
	
	public static void main(String[] args) {
		BenzModel benz = new BenzModel();
		//存放顺序
		ArrayList<String> sequence = new ArrayList<String>();
		sequence.add("engine boom");
		sequence.add("start");
		sequence.add("stop");
		//将该顺序赋予奔驰车
		benz.setSequence(sequence);
		benz.run();
	}

	
}
