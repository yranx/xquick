package com.ranx.chowder.designPatterns.bridge_corp_copy;

/**
 * @author ranx
 * @create 2019-06-11 19:43
 **/
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出房子...");
    }

    @Override
    public void beSelled() {
        System.out.println("卖出房子...");
    }
}
