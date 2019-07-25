package com.ranx.chowder.designPatterns.factory_human;

/**
 * @author ranx
 * @create 2018-11-21 17:20
 **/
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("White skin");
    }

    @Override
    public void talk() {
        System.out.println("White Speak");
    }
}
