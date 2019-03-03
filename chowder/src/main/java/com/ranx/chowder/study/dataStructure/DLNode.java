package com.ranx.chowder.study.dataStructure;

/**
 * @author ranx
 * @create 2018-08-22 16:03
 **/
public class DLNode implements Node {

    private Object elements;

    private DLNode pre;

    private DLNode next;

    public DLNode() {
    }

    public DLNode(Object elements, DLNode pre, DLNode next) {
        this.elements = elements;
        this.pre = pre;
        this.next = next;
    }



    public DLNode getPre() {
        return pre;
    }

    public void setPre(DLNode pre) {
        this.pre = pre;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

    @Override
    public Object getData() {
        return elements;
    }

    @Override
    public void setData(Object obj) {
        elements = obj;
    }
}
