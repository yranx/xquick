package com.ranx.chowder.designPatterns.visitor_normal;

import java.util.Random;

/**
 * 结构对象
 * 产生不同元素对象<---工厂方法
 * @author ranx
 * @create 2019-05-08 19:17
 **/
public class ObjectStruture {
    //对象生成器
    public static Element createElement() {
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            return new ConcreteElement1();
        } else {
            return new ConcreteElement2();
        }
    }
}
