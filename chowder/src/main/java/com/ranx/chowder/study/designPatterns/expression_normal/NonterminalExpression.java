package com.ranx.chowder.study.designPatterns.expression_normal;

/**
 * 非终结符表达式
 * @author ranx
 * @create 2019-05-17 18:41
 **/
public class NonterminalExpression extends Expression{

    //每个非终结符表达式都会对其他表达式产生依赖
    public NonterminalExpression(Expression... expression) {
    }

    @Override
    public Object interpreter(Context ctx) {
        //进行文法处理
        return null;
    }
}
