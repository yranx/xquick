package com.ranx.chowder.study.designPatterns.template_method_extend;

/**
 * H1型号悍马模型
 * @author ranx
 * @create 2019-02-18 21:37
 **/
public class HummerH1Model extends HummerModel {
    private boolean alarmFlag = true; //响喇叭

    @Override
    public void start() {
        System.out.println("悍马H1发动。。");
    }

    @Override
    public void stop() {
        System.out.println("悍马H1停车。。。");
    }

    @Override
    public void alarm() {
        System.out.println("悍马H1鸣笛。。。");
    }

    @Override
    public void engineBoom() {
        System.out.println("悍马H1引擎轰鸣声");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }
    //客户决定要不要响喇叭
    public void setAlarm(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}
