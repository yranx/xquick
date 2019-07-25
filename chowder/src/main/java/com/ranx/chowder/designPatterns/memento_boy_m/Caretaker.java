package com.ranx.chowder.designPatterns.memento_boy_m;

/**
 * 备忘录管理者
 * @author ranx
 * @create 2019-04-28 16:13
 **/
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
