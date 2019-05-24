package com.ranx.chowder.study.designPatterns.expression_calc;

import java.util.HashMap;

/**
 * 抽象表达式
 * @author ranx
 * @create 2019-05-16 18:55
 **/
public abstract class Expression {
    //解析公式和数值，其中var中的key值是公式中的参数，value是具体的数字
    public abstract int interpreter(HashMap<String, Integer> var);
}
