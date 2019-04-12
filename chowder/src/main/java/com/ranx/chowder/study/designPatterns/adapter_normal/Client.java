package com.ranx.chowder.study.designPatterns.adapter_normal;

/**
 * @author ranx
 * @create 2019-04-12 10:52
 **/
public class Client {
    public static void main(String[] args) {
        //原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();
        //增加适配器后的业务逻辑
        Target target2 = new Adapter();
        target2.request();
    }
}
