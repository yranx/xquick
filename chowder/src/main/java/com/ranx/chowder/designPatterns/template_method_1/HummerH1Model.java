package com.ranx.chowder.designPatterns.template_method_1;

/**
 * H1型号悍马模型
 * @author ranx
 * @create 2019-02-18 21:37
 **/
public class HummerH1Model extends HummerModel{
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
    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
