package com.ranx.chowder.study.designPatterns.observer_normal;

/**
 * @author ranx
 * @create 2019-04-25 19:25
 **/
public class ConcreteSubject extends Subject {

    //具体的业务
    public void doSomething() {
        super.notifyObservers();
    }
}