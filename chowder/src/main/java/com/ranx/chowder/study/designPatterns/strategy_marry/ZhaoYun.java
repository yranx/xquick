package com.ranx.chowder.study.designPatterns.strategy_marry;

/**
 * 赵云使用计谋
 * @author ranx
 * @create 2019-04-11 14:45
 **/
public class ZhaoYun {

    public static void main(String[] args) {
        Context context;
        System.out.println("---刚刚到吴国的时候拆第一个---");
        context = new Context(new BackDoor()); //拿到妙计
        context.operate(); //拆开执行

        System.out.println("---刘备乐不思蜀了，拆第二个了---");
        context = new Context(new GivenGreenLight());
        context.operate();

        System.out.println("---有追兵了，拆第三个了---");
        context = new Context(new BlockEnemy());
        context.operate();
    }
}
