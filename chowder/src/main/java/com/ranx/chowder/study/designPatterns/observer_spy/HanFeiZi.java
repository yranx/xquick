package com.ranx.chowder.study.designPatterns.observer_spy;

/**
 * 具体的被观察者
 * @author ranx
 * @create 2019-04-23 11:00
 **/
public class HanFeiZi implements IHanFeiZi{
    private boolean isHavingBreakfast = false;
    private boolean isHavingFun = false;

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子：开始吃饭了...");
        this.isHavingBreakfast = true;
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子：开始娱乐了...");
        this.isHavingFun = true;
    }

    public boolean isHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setHavingBreakfast(boolean havingBreakfast) {
        isHavingBreakfast = havingBreakfast;
    }

    public boolean isHavingFun() {
        return isHavingFun;
    }

    public void setHavingFun(boolean havingFun) {
        isHavingFun = havingFun;
    }
}
