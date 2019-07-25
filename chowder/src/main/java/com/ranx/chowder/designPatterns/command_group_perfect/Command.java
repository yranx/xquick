package com.ranx.chowder.designPatterns.command_group_perfect;

import com.ranx.chowder.designPatterns.command_group.CodeGroup;
import com.ranx.chowder.designPatterns.command_group.PageGroup;
import com.ranx.chowder.designPatterns.command_group.RequirementGroup;

/**
 * @author ranx
 * @create 2019-04-04 16:01
 **/
public abstract class Command {
    //定义好三个组，子类可以直接使用
    protected RequirementGroup rg = new RequirementGroup();
    protected PageGroup pg = new PageGroup();
    protected CodeGroup cg = new CodeGroup();

    //要做的事
    public abstract void execute();
}
