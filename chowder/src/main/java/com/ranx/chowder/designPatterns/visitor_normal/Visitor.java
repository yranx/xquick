package com.ranx.chowder.designPatterns.visitor_normal;

/**
 * 具体访问者
 * @author ranx
 * @create 2019-05-08 19:12
 **/
public class Visitor implements IVisitor{
    @Override
    public void visit(ConcreteElement1 el1) {
        el1.doSomenthing();
    }

    @Override
    public void visit(ConcreteElement2 el2) {
        el2.doSomenthing();
    }
}
