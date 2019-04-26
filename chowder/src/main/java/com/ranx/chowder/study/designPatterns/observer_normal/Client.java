package com.ranx.chowder.study.designPatterns.observer_normal;

/**
 * @author ranx
 * @create 2019-04-25 19:27
 **/
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer obs = new ConcreteObserver();
        subject.addObserver(obs);
        subject.doSomething();
    }
}
