package com.ranx.chowder.study.designPatterns.strategy_math;

import java.util.Arrays;

/**
 * @author ranx
 * @create 2019-04-11 16:02
 **/
public class Client {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[3]);
        System.out.println("输入的参数为：" + Arrays.toString(args));
        //生成一个运算器
        CalculatorA cal = new CalculatorA();
        System.out.println("运行结果为：" + a + symbol + b + " = " + cal.exec(a, b, symbol));
    }
}
