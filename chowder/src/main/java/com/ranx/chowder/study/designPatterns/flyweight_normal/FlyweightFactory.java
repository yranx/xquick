package com.ranx.chowder.study.designPatterns.flyweight_normal;

import java.util.HashMap;

/**
 * 享元工厂
 * @author ranx
 * @create 2019-06-06 19:01
 **/
public class FlyweightFactory {
    //定义一个池容器
    private static HashMap<String, Flyweight> pool = new HashMap<String, Flyweight>();

    //享元工厂
    public static Flyweight getFlyweight(String Extrinsic) {
        //需要返回的对象
        Flyweight flyweight = null;

        if (pool.containsKey(Extrinsic)) {
            flyweight = pool.get(Extrinsic);
        } else {
            //根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight1(Extrinsic);
            pool.put(Extrinsic, flyweight);
        }

        return flyweight;
    }
}
