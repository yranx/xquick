package com.ranx.chowder.study.designPatterns.factory_human;

/**
 * 场景类Client
 * @author ranx
 * @create 2018-11-21 17:34
 **/
public class NvWa {
    public static void main(String[] args) {
        //声明工厂
        AbstractHumanFactory lu = new HumanFactory();
        System.out.println("-----火候不足，造出第一批人是白色--");
        Human whiteHuman = lu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("-----火候过足，造出第二批人是黑色--");
        Human blackHuman = lu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("-----火候正好，造出第三批人是黄色--");
        Human yellowHuman = lu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
