package com.ranx.chowder.designPatterns.abstract_factory_normal;

/**
 * 产品等级1的实现类
 * @author ranx
 * @create 2019-02-16 13:08
 **/
public class Creator1 extends AbstractCreator {
    /*
    只生产产品等级为1的A产品
     */
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

//    /*
//    只生产产品等级为1的B产品
//     */
//    @Override
//    public AbstractProductA createProductA() {
//        return new ProductB1();
//    }
}
