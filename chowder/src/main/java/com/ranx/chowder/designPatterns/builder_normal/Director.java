package com.ranx.chowder.designPatterns.builder_normal;

/**
 * @Description: 导演类
 * 起到封装作用，避免高层模块深入到建造者内部的实现类
 * @author ranx
 * @date 2019-3-20-下午6:04:50

 */
public class Director {
	private Builder builder = new ConcreteProduct();
	
	//构建不同的产品
	public Product getAProduct(){
		builder.setPart();
		/*
		 * 设置不同零件，产生不同的产品
		 */
		return builder.buildProduct();
	}
}
