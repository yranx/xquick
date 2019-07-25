package com.ranx.chowder.designPatterns.expression_calc;

import java.util.HashMap;

/**
 *抽象运算符号解析器
 * @author ranx
 * @create 2019-05-16 18:55
 **/
public abstract class SymbolExpression extends Expression{
    protected Expression left;
    protected Expression right;

    //所有的解析公式都应该只关心自己左右两个表达式的结果
    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

}
