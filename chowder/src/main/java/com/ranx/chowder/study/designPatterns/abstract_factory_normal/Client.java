package com.ranx.chowder.study.designPatterns.abstract_factory_normal;

/**
 * @author ranx
 * @create 2019-02-16 13:12
 **/
public class Client {
    //定义出两个工厂
    AbstractCreator creator1 = new Creator1();
    AbstractCreator creator2 = new Creator1();
    //产生A1对象
    AbstractProductA a1 = creator1.createProductA();
    AbstractProductA a2 = creator2.createProductA();

    /*

     */
}
