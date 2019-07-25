package com.ranx.chowder.designPatterns.command_normal;

/**
 * 抽象Command类
 * @author ranx
 * @create 2019-04-04 16:52
 **/
public abstract class Command {
    //每个命令类都必须有一个执行命令的方法
    public abstract void execute();
}
