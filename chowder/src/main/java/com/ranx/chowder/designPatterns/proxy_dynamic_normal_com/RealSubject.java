package com.ranx.chowder.designPatterns.proxy_dynamic_normal_com;

/**
 * 真实主题
 * @author ranx
 * @create 2019-03-25 18:47
 **/
public class RealSubject implements Subject {
    //业务操作
    @Override
    public void doSomething(String str) {
        System.out.println("do something! ----->" + str);
    }


}
