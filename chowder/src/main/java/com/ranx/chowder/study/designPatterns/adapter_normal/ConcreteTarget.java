package com.ranx.chowder.study.designPatterns.adapter_normal;

/**
 * 目标角色的实现类
 * @author ranx
 * @create 2019-04-12 9:52
 **/
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("if you need any help, pls call me");
    }
}
