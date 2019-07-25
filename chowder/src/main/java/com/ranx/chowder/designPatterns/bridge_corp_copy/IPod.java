package com.ranx.chowder.designPatterns.bridge_corp_copy;

/**
 * @author ranx
 * @create 2019-06-11 19:43
 **/
public class IPod extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出IPod...");
    }

    @Override
    public void beSelled() {
        System.out.println("卖出IPod...");
    }
}
