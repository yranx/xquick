package com.ranx.chowder.study.designPatterns.command_group_perfect;

/**
 * 代码组
 * @author ranx
 * @create 2019-04-04 15:42
 **/
public class CodeGroup extends Group {
    @Override
    public void find() {
        System.out.println("找到代码组...");
    }

    @Override
    public void add() {
        System.out.println("客户要求增加一项功能...");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项功能...");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一项功能...");
    }

    @Override
    public void plan() {
        System.out.println("客户要求功能变更计划...");
    }
}
