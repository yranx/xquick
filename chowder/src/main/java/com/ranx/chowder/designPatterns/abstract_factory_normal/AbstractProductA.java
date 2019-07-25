package com.ranx.chowder.designPatterns.abstract_factory_normal;

/**
 * 抽象产品类
 * @author ranx
 * @create 2019-02-16 12:33
 **/
public abstract class AbstractProductA {
    //每个产品共有的方法
    public void shareMethod(){}

    //每个产品相同方法、不同实现
    public abstract void doSomething();
}
