package com.ranx.chowder.designPatterns.strategy_math;

/**
 * 上下文封装了策略
 * @author ranx
 * @create 2019-04-11 16:30
 **/
public class Context {
    private Calculator cal = null;

    public Context(Calculator cal) {
        this.cal = cal;
    }

    public int exec(int a, int b, String symbol) {
        return this.cal.exec(a, b);
    }
}
