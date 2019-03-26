package com.ranx.chowder.study.designPatterns.proxy_dynamic_normal_com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * @author ranx
 * @create 2019-03-25 18:56
 **/
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        //寻找JoinPoint连接点，AOP框架使用元数据定义
        //执行一个前置通知
        if (true) {
            (new BeforeAdvice()).exec();
        }

        //执行目标。并返回结果
        return (T) Proxy.newProxyInstance(loader,interfaces, h);
    }
}
