package com.ranx.chowder.study.dataStructure.stack;

import com.ranx.chowder.study.dataStructure.SLNode;

/**
 * 队列的链式存储结构
 * @author ranx
 * @create 2018-08-24 14:56
 **/
public class QueueSLinked implements Queue {
    private SLNode front;
    private SLNode rear;
    private int size;

    public QueueSLinked() {
        front = new SLNode();
        rear = front;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //数据元素e入队
    @Override
    public void enqueue(Object e) {
        SLNode p = new SLNode(e, null);
        rear.setNext(p);
        rear = p;
        size ++;
    }

    //队首元素出队
    @Override
    public Object dequeue() throws QueueEmptyException {
        if (size < 1) {
            throw new QueueEmptyException("错误： 队列为空。");
        }
        SLNode p = front.getNext();
        front.setNext(p.getNext());
        size--;
        //如果队列为空,rear 指向头结点
        if (size<1) {
            rear = front;
        }
        return p.getData();
    }

    //取队首元素
    @Override
    public Object peek() throws QueueEmptyException {
        if (size < 1) {
            throw new QueueEmptyException("错误： 队列为空。");
        }
        return front.getNext().getData();
    }
}
