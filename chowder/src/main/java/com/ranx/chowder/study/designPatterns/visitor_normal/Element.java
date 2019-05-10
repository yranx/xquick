package com.ranx.chowder.study.designPatterns.visitor_normal;

/**
 * 抽象元素
 * @author ranx
 * @create 2019-05-08 19:07
 **/
public abstract class Element {
    //定义业务逻辑
    public abstract void doSomenthing();
    //允许谁来访问
    public abstract void accept(IVisitor visitor);
}
