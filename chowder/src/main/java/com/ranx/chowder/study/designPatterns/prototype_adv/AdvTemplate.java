package com.ranx.chowder.study.designPatterns.prototype_adv;

/**
 * 广告信模板
 * @author ranx
 * @create 2019-03-26 11:05
 **/
public class AdvTemplate {
    //名称
    private String advSubject = "XX银行国庆信用卡抽奖活动";
    //内容
    private String advContext = "国庆抽奖活动通知：只要刷卡就送你一百万！.....";
    //取得广告信的名称
    public String getAdvSubject() {
        return this.advSubject;
    }

    //取得广告信的内容
    public String getAdvContext() {
        return this.advContext;
    }
}
