package com.ranx.chowder.study.designPatterns.proxy_dynamic_normal;


import java.lang.reflect.InvocationHandler;

/**
 * 动态代理的场景类
 * @author ranx
 * @create 2019-03-26 9:16
 **/
public class Client {

    public static void main(String[] args) {
        //定义一个主题
        Subject subject = new RealSubject();
        //定义一个Handler
        InvocationHandler handler = new MyInvoationHandler(subject);
        //定义主题的代理
        Subject proxy = DynamicProxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                handler);

        //代理的行为
        proxy.doSomething("Finish!");
    }

}
