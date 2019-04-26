package com.ranx.chowder.study.designPatterns.observer_spy_mjava;


import java.util.Observable;
import java.util.Observer;

/**
 * 李斯
 * @author ranx
 * @create 2019-04-25 9:58
 **/
public class LiSi implements Observer {

    @Override
    public void update(Observable o, Object obj) {
        System.out.println("李斯：观察到韩非子活动，开始向老板汇报...");
        this.reportToBoss(obj.toString());
        System.out.println("李斯：汇报完毕...");
    }


    private void reportToBoss(String reportContext) {
        System.out.println("Lisi: 报告，Boss! 韩非子有活动-->" + reportContext);
    }

}
