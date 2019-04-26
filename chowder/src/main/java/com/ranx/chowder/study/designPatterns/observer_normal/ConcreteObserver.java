package com.ranx.chowder.study.designPatterns.observer_normal;

/**
 * 具体观察者
 * @author ranx
 * @create 2019-04-25 19:26
 **/
public class ConcreteObserver implements  Observer{
    @Override
    public void update() {
        System.out.println("接收到信息，并进行处理！");
    }
}
