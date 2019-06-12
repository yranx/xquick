package com.ranx.chowder.study.designPatterns.bridge_normal;

/**
 * 抽象化角色
 * @author ranx
 * @create 2019-06-12 18:59
 **/
public abstract class Abstraction {
    private Implementor imp;

    public Abstraction(Implementor imp) {
        this.imp = imp;
    }

    //自身的行为和属性
    public void request(){
        this.imp.doSomething();
    }

    //获得实现化角色
    public Implementor getImp() {
        return imp;
    }
}
