package com.ranx.chowder.study.designPatterns.observer_spy_gather;


/**
 * 通过聚集方式的场景类
 * @author ranx
 * @create 2019-04-25 15:20
 **/
public class Client {
    public static void main(String[] args) throws InterruptedException {
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
