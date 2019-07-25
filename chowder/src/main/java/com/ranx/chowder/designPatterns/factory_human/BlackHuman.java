package com.ranx.chowder.designPatterns.factory_human;

/**
 * @author ranx
 * @create 2018-11-21 17:20
 **/
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("Black skin");
    }

    @Override
    public void talk() {
        System.out.println("Black Speak");
    }
}
