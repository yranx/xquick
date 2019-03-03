package com.ranx.chowder.study.dataStructure.stack;

import com.ranx.chowder.study.dataStructure.SLNode;

import java.util.SplittableRandom;

/**
 * Stack的链式存储实现
 * @author ranx
 * @create 2018-08-23 15:15
 **/
public class StackSLinked implements Stack {
    //链表首节点引用
    private SLNode top;
    private int size;

    public StackSLinked() {
    }

    public StackSLinked(SLNode top, int size) {
        top = null;
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

    //数据元素e入栈
    @Override
    public void  push(Object e) {
        SLNode q = new SLNode(e, top);
        top = q;
        size++;
    }

    //栈顶元素出栈
    @Override
    public Object pop() throws StackEmptyException {
        if (size < 1) {
            throw new StackEmptyException("错误，堆栈为空。");
        }
        Object obj = top.getData();
        top = top.getNext();
        size --;
        return obj;
    }

    //取栈顶元素
    @Override
    public Object peek() throws StackEmptyException {
        if (size < 1) {
            throw new StackEmptyException("错误，堆栈为空。");
        }
        return top.getData();
    }
}
