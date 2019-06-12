package com.ranx.chowder.study.designPatterns.bridge_normal;

/**
 * @author ranx
 * @create 2019-06-12 19:15
 **/
public class Client {
    public static void main(String[] args) {
        Implementor imp = new ConcreteImplementor1();
        Abstraction abs = new RefineAbstraction(imp);
        abs.request();
    }
}
