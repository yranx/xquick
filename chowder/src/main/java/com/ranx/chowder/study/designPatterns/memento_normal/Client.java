package com.ranx.chowder.study.designPatterns.memento_normal;

/**
 * @author ranx
 * @create 2019-04-28 18:21
 **/
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker  = new Caretaker();
        //创建备忘录
        caretaker.setMemento(originator.createMemento());
        //恢复一个备忘录
        originator.restoreMemento(caretaker.getMemento());
    }
}
