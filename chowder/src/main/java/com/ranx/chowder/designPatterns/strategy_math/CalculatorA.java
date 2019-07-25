package com.ranx.chowder.designPatterns.strategy_math;

/**
 * 方案一：最直接的加减法
 * @author ranx
 * @create 2019-04-11 15:49
 **/
public class CalculatorA {
    // "+"
    private final static String ADD_SYMBOL = "+";
    //"-"
    private final static String SUB_SYMBOL = "-";

    public int exec (int a, int b, String symbol) {
        int result = 0;
        if (ADD_SYMBOL.equals(symbol)) {
            result = this.add(a, b);
        } else if (SUB_SYMBOL.equals(symbol)) {
            result = this.sub(a, b);
        }
        return result;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }
}
