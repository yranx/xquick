package com.ranx.chowder.study.designPatterns.memento_clone;

import com.ranx.chowder.study.designPatterns.memento_normal.Memento;

/**
 * r融合备忘录的发起人角色
 * @author ranx
 * @create 2019-04-28 18:07
 **/
public class Originator implements Cloneable{
    private Originator backup;
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public Originator createMemento() throws Exception {
        return this.backup = this.clone();
    }

    //恢复一个备忘录
    public void restoreMemento () {
        //在进行恢复前应该进行断言，防止空指针
        this.setState(this.backup.getState());
    }

    //clone当前对象
    @Override
    protected Originator clone() throws CloneNotSupportedException {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
