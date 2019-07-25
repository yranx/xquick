package com.ranx.chowder.designPatterns.bridge_corp;

/**
 * @author ranx
 * @create 2019-06-11 19:23
 **/
public class IPodCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("公司生产IPod...");
    }

    @Override
    protected void sell() {
        System.out.println("公司出售IPod...");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("公司赚钱...");
    }
}
