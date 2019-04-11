package com.ranx.chowder.study.designPatterns.strategy_normal;

/**
 * 封装角色
 * @author ranx
 * @create 2019-04-11 15:10
 **/
public class Context {
    //抽象策略
    private Strategy strategy = null;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything() {
        this.strategy.doSomething();
    }
}
