package com.ranx.chowder.study.designPatterns.template_method_normal;

/**
 * 抽象模板类
 * @author ranx
 * @create 2019-02-18 22:08
 **/
public abstract class AbstractClass {
    //基本方法
    protected abstract void doSomething();

    protected abstract void doAnything();

    //模板方法
    public void templateMethod() {
        //调用基本方法，完成相关逻辑
        this.doSomething();
        this.doAnything();
    }
}
