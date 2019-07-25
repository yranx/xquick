package com.ranx.chowder.newFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口
 * @author ranx
 * @create 2018-08-29 14:06
 **/
public class FunctionalInterfaceStudy {

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        //写法一
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }

        //写法二
        list.stream().filter(predicate).forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,  2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数据：");
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true
        eval(list, n->true);
        System.out.println("输出所有偶数：");
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true
        eval(list, n -> n%2==0);
        System.out.println("输出大于3的所有数字：");
        eval(list, n -> n>3);
        //写法二
        list.stream().filter(n -> n>3).forEach(System.out::println);
    }
}
