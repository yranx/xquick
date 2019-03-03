package com.ranx.chowder.study.designPatterns.template_method_extend;

/**
 * H2型号悍马模型
 * @author ranx
 * @create 2019-02-18 21:37
 **/
public class HummerH2Model extends HummerModel {
    @Override
    public void start() {
        System.out.println("悍马H2发动。。");
    }

    @Override
    public void stop() {
        System.out.println("悍马H2停车。。。");
    }

    @Override
    public void alarm() {
        System.out.println("悍马H2鸣笛。。。");
    }

    @Override
    public void engineBoom() {
        System.out.println("悍马H2引擎轰鸣声");
    }

    //默认没有喇叭
    protected boolean isAlarm() {
        return false;
    }

}
