package com.ranx.chowder.designPatterns.strategy_normal;

/**
 * 高层模块
 * @author ranx
 * @create 2019-04-11 15:14
 **/
public class Client {

    public static void main(String[] args) {
        //声明一个具体的策略
        Strategy strategy = new ConcreteStrategy1();
        //声明一个上下文对象
        Context context = new Context(strategy);
        //执行封装后的方法
        context.doAnything();
    }

}
