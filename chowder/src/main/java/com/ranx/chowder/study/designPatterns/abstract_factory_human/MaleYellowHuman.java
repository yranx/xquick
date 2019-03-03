package com.ranx.chowder.study.designPatterns.abstract_factory_human;

/**
 * @author ranx
 * @create 2019-02-16 11:48
 **/
public class MaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("Yellow Male");
    }
}
