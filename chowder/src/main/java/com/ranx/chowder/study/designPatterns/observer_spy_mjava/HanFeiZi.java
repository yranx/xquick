package com.ranx.chowder.study.designPatterns.observer_spy_mjava;


import java.util.ArrayList;
import java.util.Observable;

/**
 * 具体的被观察者
 * @author ranx
 * @create 2019-04-23 11:00
 **/
public class HanFeiZi extends Observable implements IHanFeiZi {

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子：开始吃饭了...");
        this.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子：开始娱乐了...");
        this.notifyObservers("韩非子在娱乐");
    }
}
