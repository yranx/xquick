package com.ranx.chowder.designPatterns.visitor_normal;

/**
 * @author ranx
 * @create 2019-05-08 19:10
 **/
public class ConcreteElement2 extends Element {
    @Override
    public void doSomenthing() {

    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
