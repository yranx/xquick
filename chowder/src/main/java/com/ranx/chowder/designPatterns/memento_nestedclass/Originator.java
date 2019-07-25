package com.ranx.chowder.designPatterns.memento_nestedclass;

/**
 * 发起人角色
 * @author ranx
 * @create 2019-04-28 18:07
 **/
public class Originator {
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public IMemento createMemento() {
        return new Memento(this.state);
    }

    //恢复一个备忘录
    public void restoreMemento (IMemento memento) {
        this.setState(((Memento) memento).getState());
    }

    //内部类
    private class Memento implements IMemento {
        //发起人的内部状态
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
}
