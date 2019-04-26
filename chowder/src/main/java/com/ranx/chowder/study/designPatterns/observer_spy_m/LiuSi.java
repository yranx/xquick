package com.ranx.chowder.study.designPatterns.observer_spy_m;


/**
 * @author ranx
 * @create 2019-04-25 9:58
 **/
public class LiuSi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("LiuSi：观察到韩非子活动，开始向老板汇报...");
        this.reportToBoss(context);
        System.out.println("LiuSi...开心");
    }

    private void reportToBoss(String reportContext) {
        System.out.println("LiuSi: 因为" + reportContext + "，所以很开心");
    }
}
