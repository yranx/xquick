package com.ranx.chowder.study.dataStructure.linearTable;

/**
 * 线性表的数组实现
 * @author ranx43
 * @create 2018-08-20 17:14
 **/
public class ListArray implements List{
    //数组的默认大小
    private final int LEN = 8;
    //数组元素比较策略
    private Strategy strategy;
    //数据元素个数
    private int size;
    //数据元素数组
    private Object[] elements;

    public ListArray() {
    }

    public ListArray(Strategy strategy, int size, Object[] elements) {
        this.strategy = strategy;
        size = 0;
        elements = new Object[LEN];
    }

    //返回线性表的大小
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        for (int i=0; i<size; i++) {
            if (strategy.equals(e, elements[i])) {
                return true;
            }
        }
        return false;
    }

    //返回数据元素e在线性表中的序号
    @Override
    public int indexOf(Object e) {
        for (int i=0; i<size; i++) {
            if (strategy.equals(e, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    //将元素e插入到线性表中i号位置
    @Override
    public void insert(int i, Object e) throws OutOfBoundaryException {
        if (i<0 || i>size) {
            throw new OutOfBoundaryException("错误，指定的插入序号越界。");
        }
        if (size >= elements.length) {
            expandSpace();
        }
        for (int j=size; j>i; j--) {
            elements[j] = elements[j-1];
        }
        elements[i] = e;
        size++;
        return ;
    }

    public void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        for (int i=0; i<elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }

    //将数据元素e插入到元素obj之前 [nice!!]
    @Override
    public boolean insertBefore(Object obj, Object e) {
        int i = indexOf(obj);
        if (i<0) {
            return false;
        }
        insert(i, e);
        return true;
    }

    //将数据元素e插入到元素obj后
    @Override
    public boolean insertAfter(Object obj, Object e) {
        int i = indexOf(obj);
        if (i<0) {
            return false;
        }
        insert(i+1, e);
        return true;
    }

    //删除线性表中序号为i的元素，并返回
    @Override
    public Object remove(int i) throws OutOfBoundaryException {
        if (i<0 || i>size) {
            throw new OutOfBoundaryException("错误，指定的删除序号越界。");
        }
        Object obj = elements[i];
        for (int j=i; j<size-1; j++) {
            elements[j] = elements[j+1];
        }
        elements[--size] = null;
        return obj;
    }

    //删除线性表中都一个与e相同的元素
    @Override
    public boolean remove(Object e) {
        int i= indexOf(e);
        if (i<0) {
            return false;
        }
        remove(i);
        return true;
    }

    //替换线性表中序号为i的数据元素为e, 返回原数据元素
    @Override
    public Object replace(int i, Object e) throws OutOfBoundaryException {
        if (i<0 || i>size) {
            throw new OutOfBoundaryException("错误，指定的序号越界。");
        }
        Object obj = elements[i];
        elements[i] = e;
        return obj;
    }

    //返回线性表中序号为i的数据元素
    @Override
    public Object get(int i) throws OutOfBoundaryException {
        if (i<0 || i>size) {
            throw new OutOfBoundaryException("错误，指定的序号越界。");
        }
        return elements[i];
    }
}
