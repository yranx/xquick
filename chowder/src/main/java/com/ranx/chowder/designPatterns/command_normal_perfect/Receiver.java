package com.ranx.chowder.designPatterns.command_normal_perfect;

/**
 * 通用Receiver类
 * @author ranx
 * @create 2019-04-04 16:42
 **/
public abstract class Receiver {
    //抽象接收者，定义每个接收者都必须完成的业务
    public abstract void doSomething();
}
