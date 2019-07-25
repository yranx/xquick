package com.ranx.chowder.designPatterns.command_group_perfect;

/**
 * 负责人
 * @author ranx
 * @create 2019-04-04 16:15
 **/
public class Invoker {
    private Command command;

    //客户发出命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //执行客户的命令
    public void action() {
        this.command.execute();
    }
}
