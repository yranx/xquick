package com.ranx.chowder.study.designPatterns.builder_normal;

/**
 * @Description: 具体建造者
 * @author ranx
 * @date 2019-3-20-下午6:02:05

 */
public class ConcreteProduct extends Builder {
	
	private Product product = new Product();

	@Override
	public void setPart() {
		//产品类内的逻辑处理

	}

	@Override
	public Product buildProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
