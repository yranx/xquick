package com.ranx.chowder.designPatterns.command_normal_perfect;

import com.ranx.chowder.designPatterns.command_normal.Command;

/**
 * 调用者
 * @author ranx
 * @create 2019-04-04 17:01
 **/
public class Invoker {
    private Command command;
    //接收命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //执行命令
    public void action() {
        this.command.execute();
    }
}
