package com.ranx.chowder.designPatterns.Iterator_normal;

/**
 * 场景类
 * @author ranx
 * @create 2019-04-16 17:17
 **/
public class Client {
    public static void main(String[] args) {
        Aggregate agg = new ConcreteAggregate();
        agg.add("abc");
        agg.add("aaa");
        agg.add("5705");
        Iterator iterator = agg.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
