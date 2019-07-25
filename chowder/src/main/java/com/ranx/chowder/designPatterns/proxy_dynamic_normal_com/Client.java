package com.ranx.chowder.designPatterns.proxy_dynamic_normal_com;


import java.lang.reflect.InvocationHandler;

/**
 * 场景类
 * @author ranx
 * @create 2019-03-26 9:16
 **/
public class Client {

    public static void main(String[] args) {
        //定义一个主题
        Subject subject = new RealSubject();
        //定义主题的代理
        Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);

        //代理的行为
        proxy.doSomething("Finish!");
    }

}
