package com.ranx.chowder.dataStructure.stack;

/**
 * 队列的顺序实现
 * @author ranx
 * @create 2018-08-24 14:06
 **/
public class QueueArray implements  Queue{
    private static final int CAP = 7;
    //数据元素数组
    private Object[] elements;
    //数组的大小elements.length
    private int capacity;
    //队首指针
    private int front;
    //队尾指针
    private int rear;

    public QueueArray() {
        this(CAP);
    }

    public QueueArray(int cap) {
        capacity = cap + 1;
        elements = new Object[capacity];
        front = rear = 0;
    }

    @Override
    public int getSize() {
        return (rear - front + capacity) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    //数据元素e入队
    @Override
    public void enqueue(Object e) {
        if(getSize() == capacity-1) {
            expandSpace();
        }
        elements[rear] = e;
        rear = (rear+1) % capacity;
    }

    private void expandSpace() {
        Object[] a = new Object[elements.length*2];
        int i = front;
        int j = 0;
        //将从 front 开始到 rear 前一个存储单元的元素复制到新数组
        while (i != rear) {
            a[j++] = elements[i];
            i = (i+1) % capacity;
        }
        elements = a;
        capacity = elements.length;
        front = 0;
        rear = j;
    }

    //队首元素出队
    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("错误：队列为空。");
        }
        Object obj = elements[front];
        elements[front] = null;
        front = (front+1) % capacity;
        return obj;
    }

    //取队首元素
    @Override
    public Object peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("错误：队列为空。");
        }
        return  elements[front];
    }
}
