package com.ranx.chowder.designPatterns.factory_simple;

import com.ranx.chowder.designPatterns.factory_human.*;
import com.ranx.chowder.designPatterns.factory_human.HumanFactory;

/**
 * 场景类Client
 * @author ranx
 * @create 2018-11-21 17:34
 **/
public class NvWa {
    public static void main(String[] args) {
        //声明工厂
        System.out.println("-----火候不足，造出第一批人是白色--");
        Human whiteHuman = com.ranx.chowder.designPatterns.factory_simple.HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("-----火候过足，造出第二批人是黑色--");
        Human blackHuman = com.ranx.chowder.designPatterns.factory_simple.HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("-----火候正好，造出第三批人是黄色--");
        Human yellowHuman = com.ranx.chowder.designPatterns.factory_simple.HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
