package com.ranx.chowder.study.designPatterns.observer_spy_mjava;


import java.util.Observable;
import java.util.Observer;

/**
 * @author ranx
 * @create 2019-04-25 9:58
 **/
public class LiuSi implements Observer {

    @Override
    public void update(Observable o, Object obj) {
        System.out.println("LiuSi：观察到韩非子活动，开始向老板汇报...");
        this.reportToBoss(obj.toString());
        System.out.println("LiuSi...开心");
    }

    private void reportToBoss(String reportContext) {
        System.out.println("LiuSi: 因为" + reportContext + "，所以很开心");
    }


}
