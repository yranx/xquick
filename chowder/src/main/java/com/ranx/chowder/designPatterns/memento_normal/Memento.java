package com.ranx.chowder.designPatterns.memento_normal;

/**
 * 备忘录角色
 * 备忘他的状态
 * @author ranx
 * @create 2019-04-28 18:18
 **/
public class Memento {
    private String state = "";

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
