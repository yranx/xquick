package com.ranx.chowder.study.designPatterns.expression_normal;

/**
 * 抽象表达式
 * @author ranx
 * @create 2019-05-17 18:33
 **/
public abstract class Expression {
    //每个表达式必须有一个解析任务
    public abstract Object interpreter(Context ctx);
}
