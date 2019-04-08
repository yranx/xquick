package com.ranx.chowder.study.designPatterns.command_normal;

/**
 * 具体Command类
 * @author ranx
 * @create 2019-04-04 16:55
 **/
public class ConcreteCommand1 extends Command {
    private Receiver receiver;
    //构造函数传递接收者

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //业务处理
        this.receiver.doSomething();
    }
}
