package com.ranx.chowder.study.designPatterns.memento_normal;

/**
 * 备忘录管理员角色
 * @author ranx
 * @create 2019-04-28 18:19
 **/
public class Caretaker {
    //备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
