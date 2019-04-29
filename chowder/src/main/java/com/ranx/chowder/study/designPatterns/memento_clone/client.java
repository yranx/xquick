package com.ranx.chowder.study.designPatterns.memento_clone;

/**
 * @author ranx
 * @create 2019-04-28 18:21
 **/
public class client {
    public static void main(String[] args) throws Exception{
        Originator originator = new Originator();
        originator.setState("初始状态。。。");
        System.out.println("初始状态是：" + originator.getState());
        originator.createMemento();
        originator.setState("修改后的状态。。。");
        System.out.println("修改后的状态是：" + originator.getState());
        //恢复原有状态
        originator.restoreMemento();
        System.out.println("恢复后的状态是：" + originator.getState());
    }
}
