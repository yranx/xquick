package com.ranx.chowder.study.designPatterns.state_normal;

/**
 * 抽象环境角色
 * 声明一个环境角色，提供各个状态类自行访问，
 * 并提供所有状态的抽象行为，由各个实现类实现
 * @author ranx
 * @create 2019-05-14 19:18
 **/
public abstract class State {
    //定义一个环境角色，提供子类访问
    protected  Context context;
    //设置环境角色

    public void setContext(Context context) {
        this.context = context;
    }

    //行为1
    public abstract void handle1();
    //行为2
    public abstract void handle2();
}
