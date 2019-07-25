package com.ranx.chowder.designPatterns.composite_normal_lucency;

import java.util.ArrayList;

/**
 * 抽象构件
 * @author ranx
 * @create 2019-04-22 10:39
 **/
public abstract class Component {
    //个体和整体都具有的共享
    public void doSomething() {
        //业务逻辑
    }

    //增加一个叶子构件或树枝构件
    public abstract void add(Component component);

    //删除一个叶子构件或树枝构件
    public abstract void remve(Component component);

    //获得分支下的所有叶子构件或树枝构件
    public abstract ArrayList<Component> getChildren();
}
