package com.ranx.chowder.study.designPatterns.adapter_normal;

/**
 * 源角色
 * @author ranx
 * @create 2019-04-12 9:55
 **/
public class Adaptee {
    //原有的业务逻辑
    public void doSomething() {
        System.out.println("I'm kind of busy, leave me alone, pls!");
    }
}
