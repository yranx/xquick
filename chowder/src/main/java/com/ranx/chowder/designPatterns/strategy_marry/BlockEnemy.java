package com.ranx.chowder.designPatterns.strategy_marry;

/**
 * 孙夫人断后
 * @author ranx
 * @create 2019-04-11 9:26
 **/
public class BlockEnemy implements IStrategy{
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
