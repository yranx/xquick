package com.ranx.chowder.dataStructure.linearTable;

import com.ranx.chowder.dataStructure.Node;

/**
 * 基于LinkedList聚集对象的迭代器实现
 * @author ranx
 * @create 2018-08-23 13:18
 **/
public class LinkedListIterator implements Iterator {
    //链接表
    private LinkedList list;
    //当前节点
    private Node current;

    public LinkedListIterator(LinkedList list) {
        this.list = list;
        if (list.isEmpty()) { //若列表为空
            current = null; //则当前元素置空
        } else {
            current = list.first(); //否则从第一个元素开始
        }
    }

    //移动到第一个元素
    @Override
    public void first() {
        if (list.isEmpty()) { //若列表为空
            current = null; //则当前元素置空
        } else {
            current = list.first(); //否则从第一个元素开始
        }
    }

    //移动到下一个元素
    @Override
    public void next() throws OutOfBoundaryException {
        if (isDone()) {
            throw new OutOfBoundaryException("错误：已经没有元素。");
        }

        if (current == list.last()) {
            current = null; //当前元素后面没有更多元素
        } else {
            current = list.getNext(current);
        }
    }

    //检查迭代器中是否还有剩余元素
    @Override
    public boolean isDone() {
        return current == null;
    }

    //返回当前元素
    @Override
    public Object currentItem() throws OutOfBoundaryException{
        if (isDone()) {
            throw new OutOfBoundaryException("错误：已经没有元素。");
        }
        return current.getData();
    }
}
