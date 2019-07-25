package com.ranx.chowder.designPatterns.memento_nestedclass;

import java.util.HashMap;

/**
 * 备忘录管理员角色
 * @author ranx
 * @create 2019-04-28 18:19
 **/
public class Caretaker {
    //备忘录对象
    private IMemento memento;

    public IMemento getMemento() {
        return memento;
    }

    public void setMemento(IMemento memento) {
        this.memento = memento;
    }
}
