package com.ranx.chowder.study.designPatterns.abstract_factory_normal;

/**
 * 抽象工厂类
 * @author ranx
 * @create 2019-02-16 12:40
 **/
public abstract class AbstractCreator {
    /*
    有N个产品族，在抽象工厂类中就应该有N个创建方法
     */
    //创建A产品家族
    public abstract AbstractProductA createProductA();

    //创建B产品家族
//    public abstract AbstractProductB createProductB();
}
