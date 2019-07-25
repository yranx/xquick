package com.ranx.chowder.designPatterns.expression_calc;

import java.util.HashMap;

/**
 * 变量解析器
 * @author ranx
 * @create 2019-05-16 18:55
 **/
public  class VarExpression extends Expression{
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
