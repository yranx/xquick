package com.ranx.chowder.study.designPatterns.strategy_normal;

/**
 * 具体策略角色
 * @author ranx
 * @create 2019-04-11 15:05
 **/
public class ConcreteStrategy2 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略2的运算法则");
    }
}
