package com.ranx.chowder.designPatterns.command_group_perfect;

/**
 * 增加需求的命令
 * @author ranx
 * @create 2019-04-04 16:07
 **/
public class AddRequirementCommand extends Command {
    //具体执行
    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
}
