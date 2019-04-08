package com.ranx.chowder.study.designPatterns.command_group_perfect;

/**
 * 删除页面的命令
 * @author ranx
 * @create 2019-04-04 16:11
 **/
public class DeletePageCommand extends Command {
    //具体执行
    @Override
    public void execute() {
        super.pg.find();
        super.rg.delete();
        super.rg.plan();
    }
}
