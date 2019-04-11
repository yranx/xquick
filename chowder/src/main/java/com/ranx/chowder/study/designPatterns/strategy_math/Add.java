package com.ranx.chowder.study.designPatterns.strategy_math;

/**
 * @author ranx
 * @create 2019-04-11 16:28
 **/
public class Add implements Calculator {
    @Override
    public int exec(int a, int b) {
        return a + b;
    }
}
