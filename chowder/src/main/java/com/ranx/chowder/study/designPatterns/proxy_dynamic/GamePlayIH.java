package com.ranx.chowder.study.designPatterns.proxy_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * @author ranx
 * @create 2019-03-25 15:43
 **/
public class GamePlayIH implements InvocationHandler{
    //被代理者
    Class cls =  null;
    //被代理的实例
    Object obj = null;
    //我要代理谁
    public GamePlayIH(Object obj) {
        this.obj = obj;
    }

    //调用被代理的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj, args);
        //如果是登录方法，则发送信息
        if ("login".equals(method.getName())) {
            System.out.println("有人在用我的账号登录！");
        }
        return result;
    }
}
