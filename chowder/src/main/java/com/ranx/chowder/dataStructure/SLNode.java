package com.ranx.chowder.dataStructure;

/**
 * 单链表节点
 * @author ranx
 * @create 2018-08-20 17:01
 **/
public class SLNode implements Node {
    private Object element;
    private SLNode next;

    public SLNode() {
    }

    public SLNode(Object element, SLNode next) {
        this.element = element;
        this.next = next;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object obj) {
        element = obj;
    }
}
