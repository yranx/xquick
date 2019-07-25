package com.ranx.chowder.dataStructure.linearTable;

/**
 * 迭代器
 * @author ranx
 * @create 2018-08-23 11:19
 * 迭代器（Iterator）是程序设计的一种模式，它属于设计模式中的行为模式，它的功能是
 * 提供一种方法顺序访问一个聚集对象中各个元素，而又不需暴露该对象的内部表示
 **/
public interface Iterator {
    //移动到第一个元素
    public void first();
    //移动到下一个元素
    public void next();
    //检查迭代中是否还有剩余的元素
    public boolean isDone();
    //返回当前元素
    public Object currentItem();
}
