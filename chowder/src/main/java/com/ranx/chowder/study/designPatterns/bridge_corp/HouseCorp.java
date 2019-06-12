package com.ranx.chowder.study.designPatterns.bridge_corp;

/**
 * @author ranx
 * @create 2019-06-11 19:23
 **/
public class HouseCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("房地产公司盖房子...");
    }

    @Override
    protected void sell() {
        System.out.println("房地产公司出售房子...");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚钱...");

    }
}
