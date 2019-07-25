package com.ranx.chowder.designPatterns.strategy_math;

/**
 * @author ranx
 * @create 2019-04-11 16:28
 **/
public class Sub implements Calculator{
    @Override
    public int exec(int a, int b) {
        return a - b;
    }
}
