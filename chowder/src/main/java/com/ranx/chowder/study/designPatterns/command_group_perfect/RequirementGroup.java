package com.ranx.chowder.study.designPatterns.command_group_perfect;

import com.ranx.chowder.study.designPatterns.command_group.Group;

/**
 * 需求组
 * @author ranx
 * @create 2019-04-04 15:42
 **/
public class RequirementGroup extends Group {
    @Override
    public void find() {
        System.out.println("找到需求组...");
    }

    @Override
    public void add() {
        System.out.println("客户要求增加一项需求...");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项需求...");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一项需求...");
    }

    @Override
    public void plan() {
        System.out.println("客户要求需求计划...");
    }
}
