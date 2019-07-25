package com.ranx.chowder.designPatterns.chain_of_responsibility_normal;

/**
 * @author ranx
 * @create 2019-04-08 18:18
 **/
public class Client {

    public static void main(String[] args) {
        //声明所有的处理节点
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        //设置链中的阶段顺序1-> 2 ->3
        handler1.setNext(handler2);
        handler2.setNext(handler3);

        //提交请求，返回结果
        Response response = handler1.handleMessage(new Request());
    }
}
