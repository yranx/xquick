package com.ranx.chowder.designPatterns.observer_spy_mjava;

import java.util.Observer;

/**
 * 通过聚集方式的场景类
 * @author ranx
 * @create 2019-04-25 15:20
 **/
public class Client {
    public static void main(String[] args){
        Observer lisi = new LiSi();
        Observer wangsi = new WangSi();
        Observer liusi = new LiuSi();

        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(lisi);
        hanFeiZi.addObserver(wangsi);
        hanFeiZi.addObserver(liusi);
        hanFeiZi.haveBreakfast();
    }
}
