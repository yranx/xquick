package com.ranx.chowder.designPatterns.adapter_normal;

/**
 * 适配器角色
 * @author ranx
 * @create 2019-04-12 9:58
 **/
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.doSomething();
    }
}
