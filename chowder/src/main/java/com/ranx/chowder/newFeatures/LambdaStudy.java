package com.ranx.chowder.newFeatures;

/**
 *  Lambda表达式书写
 * @author ranx
 * @create 2018-08-29 10:47
 **/
public class LambdaStudy {

    interface MathOperation {
        int operation(int a, int b);
    }


    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    public static void main (String args[]) {
        LambdaStudy lambdaStudy = new LambdaStudy();

        //类型声明
        MathOperation add = (int a, int b) -> a + b;

        //不用类型声明
        MathOperation sub = (a, b) ->  a - b;

        //大括号中的返回语句
        MathOperation mul = (int a, int b) -> { return a * b;};

        //没有大括号及返回语句
        MathOperation div = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambdaStudy.operate(10, 5, add));
        System.out.println("10 - 5 = " + lambdaStudy.operate(10, 5, sub));
        System.out.println("10 * 5 = " + lambdaStudy.operate(10, 5, mul));
        System.out.println("10 / 5 = " + lambdaStudy.operate(10, 5, div));

        //不用括号
        GreetingService greetingService1 = message -> System.out.println("hello " + message);
        greetingService1.sayMessage("ranx");
        //用括号
        GreetingService greetingService2 = (message) -> System.out.println("hello " + message);
        greetingService2.sayMessage("ranxx");
    }
}
