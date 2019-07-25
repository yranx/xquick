package com.ranx.chowder.designPatterns.abstract_factory_human;

/**
 * @author ranx
 * @create 2019-02-16 11:16
 **/
public abstract class AbstractYellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("Yellow skin");;
    }
    
    @Override
    public void talk() {
        System.out.println("Yellow Speak");
    }
}
