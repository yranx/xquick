package com.ranx.chowder.designPatterns.memento_mulstamem;

import java.util.HashMap;

/**
 * 备忘录管理员角色
 * @author ranx
 * @create 2019-04-28 18:19
 **/
public class Caretaker {
    //容纳备忘录的容器
    private HashMap<String, Memento> memMap = new HashMap<String, Memento>();

    public Memento getMemento(String idx) {
        return memMap.get(idx);
    }

    public void setMemento(String idx, Memento memento) {
        this.memMap.put(idx, memento);
    }
}
