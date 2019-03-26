package com.ranx.chowder.study.designPatterns.proxy_dynamic_normal_com;

import java.lang.reflect.InvocationHandler;

/**
 * 具体业务的动态代理
 * @author ranx
 * @create 2019-03-26 9:45
 **/
public class SubjectDynamicProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject subject) {
        //获得ClassLoader
        ClassLoader loader = subject.getClass().getClassLoader();
        //获得接口数组
        Class<?>[] classes = subject.getClass().getInterfaces();
        //获得handler
        InvocationHandler handler = new MyInvoationHandler(subject);
        return newProxyInstance(loader, classes, handler);
    }
}
