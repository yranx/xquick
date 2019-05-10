package com.ranx.chowder.study.designPatterns.command_normal_perfect;

/**
 * 完美的Command类
 * @author ranx
 * @create 2019-04-04 16:52
 **/
public abstract class Command {
    //定义一个子类的全局共享变量
    protected final Receiver receiver;

    //实现类必须定义一个接收者
    //通过构造函数约定每个具体命令都必须指定接收者
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    //每个命令类都必须有一个执行命令的方法
    public abstract void execute();
}
