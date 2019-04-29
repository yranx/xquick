package com.ranx.chowder.study.designPatterns.memento_mulstate;

/**
 * @author ranx
 * @create 2019-04-28 18:21
 **/
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker  = new Caretaker();
        originator.setState1("中国");
        originator.setState2("强盛");
        originator.setState3("繁荣");
        System.out.println("初始化状态====" + originator);
        //创建备忘录
        caretaker.setMemento(originator.createMemento());
        //修改状态值
        originator.setState1("软件");
        originator.setState2("架构");
        originator.setState3("优秀");
        System.out.println("修改后状态====" + originator);
        //恢复一个备忘录
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复后状态====" + originator);
    }
}
