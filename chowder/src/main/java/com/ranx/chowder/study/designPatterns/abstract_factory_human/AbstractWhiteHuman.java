package com.ranx.chowder.study.designPatterns.abstract_factory_human;

/**
 * @author ranx
 * @create 2019-02-16 11:16
 **/
public abstract class AbstractWhiteHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("White skin");;
    }

    @Override
    public void talk() {
        System.out.println("White Speak");
    }
}
