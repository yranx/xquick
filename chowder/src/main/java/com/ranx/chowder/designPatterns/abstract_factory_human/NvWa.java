package com.ranx.chowder.designPatterns.abstract_factory_human;

/**
 * 场景类Client
 * @author ranx
 * @create 2018-11-21 17:34
 **/
public class NvWa {
    public static void main(String[] args) {
        //生产线
        HumanFactory maleHumanFactory = new MaleFactory();
        HumanFactory femaleHumanFactory = new FemaleFactory();
        // 开始生产人
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        System.out.println("生产一个黄色女性");
        femaleYellowHuman.getColor();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
        System.out.println("生产一个黄色男性");
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();

        //......
    }
}
