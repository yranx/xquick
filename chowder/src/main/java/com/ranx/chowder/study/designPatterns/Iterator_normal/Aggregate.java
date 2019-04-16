package com.ranx.chowder.study.designPatterns.Iterator_normal;

/**
 * 抽象容器
 * @author ranx
 * @create 2019-04-16 17:09
 **/
public interface Aggregate {
    public void add(Object object);

    public void remove(Object object);

    public Iterator iterator();
}
