package com.ranx.chowder.study.designPatterns.command_group_perfect;

/**
 * 抽象组
 * @author ranx
 * @create 2019-04-04 15:36
 **/
public abstract class Group {
    //找到该组
    public abstract void find();
    //被要求增加的功能
    public abstract void add();
    //被要求删除的功能
    public abstract void delete();
    //被要求修改功能
    public abstract void change();
    //被要求给出所有的变更计划
    public abstract void plan();
}
