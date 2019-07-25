package com.ranx.chowder.designPatterns.abstract_factory_human;

/**
 * @author ranx
 * @create 2019-02-16 11:16
 **/
public abstract class AbstractBlackHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("Black skin");;
    }
    
    @Override
    public void talk() {
        System.out.println("Black Speak");
    }
}
