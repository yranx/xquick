package com.ranx.chowder.designPatterns.command_normal;

/**
 * @author ranx
 * @create 2019-04-04 17:06
 **/
public class Client {
    public static void main(String[] args) {
        //声明调用者Invoker
        Invoker invoker = new Invoker();
        //定义接收者
        Receiver receiver = new ConcreteReceiver1();
        //定义一个发送给接受者的命令
        Command command = new ConcreteCommand1(receiver);
        //将命令交给调用者去执行
        invoker.setCommand(command);
        invoker.action();
    }
}