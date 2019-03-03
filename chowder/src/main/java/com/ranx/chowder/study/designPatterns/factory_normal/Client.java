package com.ranx.chowder.study.designPatterns.factory_normal;

/**
 * 场景类
 * @author ranx
 * @create 2019-02-15 16:56
 **/
public class Client {
    public static void main(String[] args) {
        AbstractCreatorFactory creatorFactory = new CreatorFactory();
        Product product = creatorFactory.createProduct(ProductConcrete1.class);

        //继续业务处理
    }
}
