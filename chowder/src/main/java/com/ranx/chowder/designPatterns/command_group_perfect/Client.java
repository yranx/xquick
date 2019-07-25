package com.ranx.chowder.designPatterns.command_group_perfect;

/**
 * @author ranx
 * @create 2019-04-04 16:20
 **/
public class Client {

    public static void main(String[] args) {
        //定义接头负责人
        Invoker invoker = new Invoker();
        System.out.println("----------------客户要求增加一项需求-----------------");
        //客户的命令
        Command command = new AddRequirementCommand();
        invoker.setCommand(command);
        invoker.action();
    }
}
