package com.ranx.chowder.study.designPatterns.strategy_marry;

/**
 * 锦囊
 * @author ranx
 * @create 2019-04-11 14:41
 **/
public class Context {

    private IStrategy strategy;
    //通过构造函数传入策略
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    //执行相关的策略
    public void operate() {
        this.strategy.operate();
    }
}
