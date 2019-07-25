package com.ranx.chowder.designPatterns.Iterator_normal;

/**
 * 抽象迭代器
 * @author ranx
 * @create 2019-04-16 16:40
 **/
public interface Iterator {
    //遍历到下一个元素
    public Object next();
    //是否已经遍历到尾部
    public boolean hasNext();
    //删除当前指定的元素
    public boolean remove();
}
