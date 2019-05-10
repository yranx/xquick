package com.ranx.chowder.study.designPatterns.visitor_normal;

/**
 * 具体元素
 * @author ranx
 * @create 2019-05-08 19:10
 **/
public class ConcreteElement1 extends Element {
    @Override
    public void doSomenthing() {

    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
