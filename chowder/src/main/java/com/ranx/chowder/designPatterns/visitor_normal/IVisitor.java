package com.ranx.chowder.designPatterns.visitor_normal;

/**
 * 抽象访问者
 * @author ranx
 * @create 2019-05-08 19:09
 **/
public interface IVisitor {
    //可以访问的对象
    public void visit(ConcreteElement1 el1);
    public void visit(ConcreteElement2 el2);

}
