package com.ranx.chowder.study.designPatterns.state_normal;

/**
 * @author ranx
 * @create 2019-05-14 19:31
 **/
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteState1());
        context.handle1();
        context.handle2();
    }
}
