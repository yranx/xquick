package com.ranx.chowder.study.designPatterns.template_method_1;

/**
 * 抽象悍马模型
 * @author ranx
 * @create 2019-02-18 21:32
 **/
public abstract class HummerModel {
    //启动
    public abstract void start();

    //停止
    public abstract void stop();

    //喇叭鸣叫
    public abstract void alarm();

    //引擎声音
    public abstract void engineBoom();

    //上路跑动
    public abstract void run();

}
