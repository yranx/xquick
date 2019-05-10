package com.ranx.chowder.study.designPatterns.command_normal_perfect;

import com.ranx.chowder.study.designPatterns.command_normal.Command;
import com.ranx.chowder.study.designPatterns.command_normal.ConcreteCommand1;
import com.ranx.chowder.study.designPatterns.command_normal.ConcreteReceiver1;
import com.ranx.chowder.study.designPatterns.command_normal.Invoker;
import com.ranx.chowder.study.designPatterns.command_normal.Receiver;

/**
 * @author ranx
 * @create 2019-04-04 17:06
 **/
public class Client {
    public static void main(String[] args) {
        //声明调用者Invoker
        Invoker invoker = new Invoker();
        //定义一个发送给接受者的命令
//        Command command = new ConcreteCommand1(); //TODO
        //将命令交给调用者去执行
//        invoker.setCommand(command);
//        invoker.action();
    }
}