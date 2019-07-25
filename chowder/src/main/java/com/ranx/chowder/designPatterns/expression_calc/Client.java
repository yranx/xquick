package com.ranx.chowder.designPatterns.expression_calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author ranx
 * @create 2019-05-16 19:25
 **/
public class Client {
    public static void main(String[] args) throws IOException{
        String expStr = getExpStr();
        //赋值
        HashMap<String, Integer> var = getValue(expStr);
        Calculator calc = new Calculator(expStr);
        System.out.println("运算结果为：" + expStr + '=' + calc.run(var));
    }

    //获取表达式(公式)
    public static String getExpStr() throws IOException{
        System.out.println("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    //获得值映射(从键盘事件中获得表达式中的元素映射值)（公式元素映射为具体数值）
    public static HashMap<String, Integer> getValue(String exprStr) throws IOException{
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //解析有几个参数要传递
        for (char ch : exprStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                //解决重复参数的问题
                if (!map.containsKey(String.valueOf(ch))) {
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
