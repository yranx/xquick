package com.ranx.chowder.designPatterns.memento_boy_m;

/**
 * 备忘录:保留男孩当时状态
 * @author ranx
 * @create 2019-04-28 15:43
 **/
public class Memento {
    //男孩状态
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
