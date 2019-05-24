package com.ranx.chowder.study.designPatterns.expression_calc;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ranx
 * @create 2019-05-16 19:04
 **/
public class Calculator {

    private Expression expression;

    public Calculator(String expStr) {
        //定义一个栈，安排运算的先后顺序
        Stack<Expression> stack = new Stack<Expression>();
        //表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();
        //运算
        Expression left = null;
        Expression right = null;
        for (int i=0; i<charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i])); //右边字符初始化为符号
                    stack.push(new AddExpression(left,right)); //结果入栈
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                    default:
                        //公式中的变量-->a,b,c也就是数字之类
                        stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        //抛出运算结果
        this.expression = stack.pop();
    }

    //开始运算
    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
