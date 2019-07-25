package com.ranx.chowder.designPatterns.expression_calc;

import java.util.HashMap;

/**
 * 加法解析器
 * @author ranx
 * @create 2019-05-16 19:02
 **/
public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
