package com.ranx.chowder.designPatterns.command_normal_perfect;

/**
 * 具体Command类
 * @author ranx
 * @create 2019-04-04 16:55
 **/
public class ConcreteCommand1 extends Command {

    //声明自己的默认接收者
    //这里有问题 TODO
//    public ConcreteCommand1() {
//        super(new ConcreteReceiver1());
//    }

    //构造函数传递接收者
    public ConcreteCommand1(Receiver receiver) {
       super(receiver);
    }



    @Override
    public void execute() {
        //业务处理
        super.receiver.doSomething();
    }
}
