package com.ranx.chowder.designPatterns.factory_human;

/**
 * @author ranx
 * @create 2018-11-21 17:20
 **/
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("Yellow skin");
    }

    @Override
    public void talk() {
        System.out.println("Yellow Speak");
    }
}
