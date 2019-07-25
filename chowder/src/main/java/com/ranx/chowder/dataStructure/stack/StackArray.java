package com.ranx.chowder.dataStructure.stack;

/**
 * Stack的顺序存储实现
 * @author ranx
 * @create 2018-08-23 14:26
 **/
public class StackArray implements Stack{
    private final int LEN = 8;
    //数据元素数组
    private Object[] elements;
    //栈顶指针
    private int top;

    public StackArray() {
        top = -1;
        elements = new Object[LEN];
    }

    @Override
    public int getSize() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return top<0;
    }

    //e入栈
    @Override
    public void push(Object e) {
        if (getSize() >= elements.length) {
            expandSpace();
        }
        elements[++top] = e;
    }

    private void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        for (int i=0; i<elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }

    //栈顶元素出栈
    @Override
    public Object pop() throws StackEmptyException {
        if (getSize()<1) {
            throw new StackEmptyException("错误，堆栈为空。");
        }
        Object obj = elements[top];
        elements[top--] = null;
        return obj;
    }

    //取栈顶元素
    @Override
    public Object peek() throws StackEmptyException {
        if (getSize()<1) {
            throw new StackEmptyException("错误，堆栈为空。");
        }
        return elements[top];
    }
}
