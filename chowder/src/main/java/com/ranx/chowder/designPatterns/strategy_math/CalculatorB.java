package com.ranx.chowder.designPatterns.strategy_math;

/**
 * 方案二： 三目运算符
 * @author ranx
 * @create 2019-04-11 16:24
 **/
public class CalculatorB {
    // "+"
    private final static String ADD_SYMBOL = "+";
    //"-"
    private final static String SUB_SYMBOL = "-";

    public int exec(int a, int b, String symbol) {
        return symbol.equals(ADD_SYMBOL) ? a+b : a-b;
    }
}
