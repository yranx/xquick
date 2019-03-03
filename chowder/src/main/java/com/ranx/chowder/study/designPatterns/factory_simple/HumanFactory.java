package com.ranx.chowder.study.designPatterns.factory_simple;

import com.ranx.chowder.study.designPatterns.factory_human.Human;

/**
 * 简单工厂模式中的工厂类
 * @author ranx
 * @create 2019-02-15 21:03
 **/
public class HumanFactory {
    public static <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        }catch (Exception e) {
            System.out.println("人种生成错误！");
        }
        return (T)human;
    }
}
