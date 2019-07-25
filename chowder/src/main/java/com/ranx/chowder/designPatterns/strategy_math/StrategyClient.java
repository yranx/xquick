package com.ranx.chowder.designPatterns.strategy_math;

import java.util.Arrays;

/**
 * @author ranx
 * @create 2019-04-11 16:35
 **/
public class StrategyClient {
    // "+"
    private final static String ADD_SYMBOL = "+";
    //"-"
    private final static String SUB_SYMBOL = "-";

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[3]);
        System.out.println("输入的参数为：" + Arrays.toString(args));

        Context context = null;
        if (ADD_SYMBOL.equals(symbol)) {
            context = new Context(new Add());
        } else if (SUB_SYMBOL.equals(symbol)){
            context = new Context(new Sub());
        }

        System.out.println("运行结果为：" + a + symbol + b + "=" + context.exec(a, b, symbol));
    }

}
