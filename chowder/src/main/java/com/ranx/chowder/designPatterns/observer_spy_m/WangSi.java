package com.ranx.chowder.designPatterns.observer_spy_m;


/**
 * @author ranx
 * @create 2019-04-25 9:58
 **/
public class WangSi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("WangSi：观察到韩非子活动，开始向老板汇报...");
        this.reportToBoss(context);
        System.out.println("WangSi伤心...");
    }

    private void reportToBoss(String reportContext) {
        System.out.println("WangSi: 因为" + reportContext + "，所以很悲伤");
    }
}
