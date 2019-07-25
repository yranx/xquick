package com.ranx.chowder.dataStructure.linearTable;

import com.ranx.chowder.dataStructure.DLNode;
import com.ranx.chowder.dataStructure.Node;

/**
 * 基于双向链表实现的链接表
 * @author ranx
 * @create 2018-08-22 15:59
 **/
public class LinkedListDLNode implements LinkedList{
    private int size;
    //头结点
    private DLNode head;
    //尾结点
    private  DLNode tail;

    public LinkedListDLNode() {
        size = 0;
        head = new DLNode();
        tail = new DLNode();
        tail.setPre(head);
    }

    //辅助方法，判断结点p是否合法，如合法转换为DLNode
    protected DLNode checkPosition(Node p) throws InvalidNodeException {
        if (p == null) {
            throw new InvalidNodeException("错误： p为空。");
        }
        if (p == head) {
            throw new InvalidNodeException("错误： p指向头结点。");
        }
        if (p == tail) {
            throw new InvalidNodeException("错误： p指向尾结点。");
        }
        DLNode node = (DLNode)p;
        return node;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public  boolean isEmpty() {
        return size == 0;
    }

    //返回第一个结点
    @Override
    public Node first() throws OutOfBoundaryException {
        if (isEmpty()) {
            throw new OutOfBoundaryException("错误：链接表为空。");
        }
        return head.getNext();
    }

    //返回最后一个结点
    @Override
    public Node last() throws OutOfBoundaryException {
        if (isEmpty()) {
            throw new OutOfBoundaryException("错误：链接表为空。");
        }
        return tail.getPre();
    }

    //返回p之后的结点
    @Override
    public Node getNext(Node p) throws InvalidNodeException,OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getNext();
        if (node == tail) {
            throw new OutOfBoundaryException("错误：已经是链接表尾端。");
        }
        return  node;
    }

    //返回p之前的结点
    @Override
    public Node getPre(Node p) throws InvalidNodeException,OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getPre();
        if (node == tail) {
            throw new OutOfBoundaryException("错误：已经是链接表尾端。");
        }
        return  node;
    }

    //将e作为第一个元素插入链接表
    @Override
    public Node insertFirst(Object e) {
        DLNode node = new DLNode(e, head, head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
        size ++;
        return node;
    }

    //将e作为最后一个元素插入链接表
    @Override
    public Node insertLast(Object e) {
        DLNode node = new DLNode(e, tail, tail.getPre());
        tail.getPre().setNext(node);
        tail.setPre(node);
        size ++;
        return node;
    }

    //将e插入至p之后的位置，并返回e所在结点
    @Override
    public Node insertAfter(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node, node.getNext());
        node.getNext().setPre(newNode);
        node.setNext(newNode);
        size++;
        return newNode;
    }

    //将e插入至p之前的位置，并返回e所在结点
    @Override
    public Node insertBefore(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node.getPre(), node);
        node.getPre().setNext(newNode);
        node.setPre(newNode);
        size++;
        return newNode;
    }

    //删除给定位置处的元素，并返回之
    @Override
    public Object remove(Node p) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
        size--;
        return obj;
    }

    //删除首元素，并返回之
    @Override
    public Object removeFirst() throws OutOfBoundaryException {
        return remove(head.getNext());
    }

    //删除尾元素，并返回
    @Override
    public Object removeLast() throws  OutOfBoundaryException {
        return remove(tail.getPre());
    }

    //将处于给定位置的元素替换为新元素，并返回被替换的元素
    @Override
    public Object replace(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.setData(e);
        return obj;
    }

    //元素迭代器
    @Override
    public Iterator elements() {
        return new LinkedListIterator(this);
    }
}
