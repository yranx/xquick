package com.ranx.chowder.designPatterns.proxy_dynamic_normal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的Handler类
 * @author ranx
 * @create 2019-03-25 18:50
 **/
public class MyInvoationHandler implements InvocationHandler{
    //被代理的对象
    private  Object target = null;

    public MyInvoationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行被代理的方法
        return method.invoke(this.target, args);
    }
}
