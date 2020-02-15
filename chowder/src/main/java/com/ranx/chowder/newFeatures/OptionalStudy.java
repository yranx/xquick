package com.ranx.chowder.newFeatures;

import java.util.Optional;

/**
 * Optional类
 * 是一个可以为null的容器对象
 * 它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 * Optional 类的引入很好的解决空指针异常。
 * @author ranx
 * @create 2018-08-29 21:41
 **/
public class OptionalStudy {
    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent 判断值是否存在
        System.out.println("第一个参数值存在： " + a.isPresent());
        System.out.println("第一个参数值存在： " + b.isPresent());

        //Optional.orElse  如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    public static void main(String args[]) {
        OptionalStudy optionalStudy = new OptionalStudy();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        //Optional.ofNullable - 允许传递为null参数
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - 如果传递的参数为null,抛出异常NPE
        Optional<Integer> b = Optional.of(value2);
        System.out.println(optionalStudy.sum(a, b));
    }
}
