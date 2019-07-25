package com.ranx.chowder.designPatterns.observer_spy_gather;

/**
 * 李斯
 * @author ranx
 * @create 2019-04-25 9:58
 **/
public class LiSi implements ILiSi {
    @Override
    public void update(String context) {
        System.out.println("李斯：观察到韩非子活动，开始向老板汇报...");
        this.reportToBoss(context);
        System.out.println("李斯：汇报完毕...");
    }

    private void reportToBoss(String reportContext) {
        System.out.println("Lisi: 报告，Boss! 韩非子有活动-->" + reportContext);
    }
}
