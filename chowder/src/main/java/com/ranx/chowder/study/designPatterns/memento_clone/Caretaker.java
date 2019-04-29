package com.ranx.chowder.study.designPatterns.memento_clone;

import com.ranx.chowder.study.designPatterns.memento_normal.Memento;

/**
 * 备忘录管理员角色
 * @author ranx
 * @create 2019-04-28 18:19
 **/
public class Caretaker {
    //备忘录对象
    private Originator originator;

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
