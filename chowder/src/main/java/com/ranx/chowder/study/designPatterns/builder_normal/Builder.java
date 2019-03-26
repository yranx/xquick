package com.ranx.chowder.study.designPatterns.builder_normal;

/**
 * @Description: 抽象建造者
 * @author ranx
 * @date 2019-3-20-下午5:59:02

 */
public abstract class Builder {
	//设置产品的不同部分，以获得不同的产品;即为零件的配置，不同零件或者不同装配顺序产生不同产品
	public abstract void setPart();
	
	//建造产品
	public abstract Product buildProduct();
}
