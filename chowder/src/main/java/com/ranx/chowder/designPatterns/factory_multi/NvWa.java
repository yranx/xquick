package com.ranx.chowder.designPatterns.factory_multi;

import com.ranx.chowder.designPatterns.factory_human.BlackHuman;
import com.ranx.chowder.designPatterns.factory_human.Human;
import com.ranx.chowder.designPatterns.factory_human.WhiteHuman;
import com.ranx.chowder.designPatterns.factory_human.YellowHuman;

/**
 * 场景类Client
 * @author ranx
 * @create 2018-11-21 17:34
 **/
public class NvWa {
    public static void main(String[] args) {
        //声明工厂
        System.out.println("-----火候不足，造出第一批人是白色--");
        Human whiteHuman = (new WhiteHumanFactory()).createHuman();
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("-----火候过足，造出第二批人是黑色--");
        Human blackHuman = (new BlackHumanFactory()).createHuman();
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("-----火候正好，造出第三批人是黄色--");
        Human yellowHuman = (new YellowHumanFactory()).createHuman();
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
