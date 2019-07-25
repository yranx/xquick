package com.ranx.chowder.designPatterns.observer_spy;


/**
 * @author ranx
 * @create 2019-04-25 15:20
 **/
public class Client {
    public static void main(String[] args) throws InterruptedException {
        LiSi liSi = new LiSi();
        HanFeiZi hanFeiZi = new HanFeiZi();
        Thread t = new Thread();
        //方法不合适，注释下
/*        //观察
        Watch watchBreakfast = new Watch(hanFeiZi, liSi, "breakfast");
        //开启线程，监控
        watchBreakfast.start();
        Watch watchFun = new Watch(hanFeiZi, liSi, "fun");
        watchFun.start();*/
        Thread.sleep(1000);
        hanFeiZi.haveBreakfast();
        Thread.sleep(1000);
        hanFeiZi.haveFun();
    }
}
