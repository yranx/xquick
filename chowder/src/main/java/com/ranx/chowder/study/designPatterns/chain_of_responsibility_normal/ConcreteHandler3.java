package com.ranx.chowder.study.designPatterns.chain_of_responsibility_normal;

/**
 * 具体处理者
 * @author ranx
 * @create 2019-04-08 18:13
 **/
public class ConcreteHandler3 extends Handler{

    //设置自己的处理级别
    @Override
    protected Level getHandlerLevel() {
        //设置自己的处理级别
        return null;
    }

    //定义自己的处理逻辑
    @Override
    protected Response echo(Request request) {
        //完成处理逻辑
        return null;
    }
}
