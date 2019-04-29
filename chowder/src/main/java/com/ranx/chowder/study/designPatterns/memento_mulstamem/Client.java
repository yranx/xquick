package com.ranx.chowder.study.designPatterns.memento_mulstamem;

/**
 * @author ranx
 * @create 2019-04-28 18:21
 **/
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker  = new Caretaker();
        //创建多个备忘录
        caretaker.setMemento("001", originator.createMemento());
        caretaker.setMemento("002", originator.createMemento());
        //恢复一个指定标记的备忘录
        originator.restoreMemento(caretaker.getMemento("001"));
    }
}
