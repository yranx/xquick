package com.ranx.chowder.study.designPatterns.expression_calc;

import java.util.HashMap;

/**
 * @author ranx
 * @create 2019-05-16 19:02
 **/
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
