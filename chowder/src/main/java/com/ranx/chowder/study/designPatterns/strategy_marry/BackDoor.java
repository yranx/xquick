package com.ranx.chowder.study.designPatterns.strategy_marry;

/**
 * 乔国老开后门
 * @author ranx
 * @create 2019-04-11 9:23
 **/
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙");
    }
}
