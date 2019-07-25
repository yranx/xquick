package com.ranx.chowder.designPatterns.memento_boy;

/**
 * 男孩状态类
 * @author ranx
 * @create 2019-04-28 9:14
 **/
public class Boy {
    private String state = "";

    public void changeState() {
        this.state = "心情可能很不好";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
