package com.ranx.chowder.designPatterns.Iterator_normal;

import java.util.Vector;

/**
 * 具体容器
 * @author ranx
 * @create 2019-04-16 17:11
 **/
public class ConcreteAggregate implements  Aggregate{
    //容纳对象的容器
    private Vector vector = new Vector();
    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    @Override
    public void remove(Object object) {
        this.remove(object);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }
}
