package com.ranx.chowder.dataStructure.linearTable;

/**
 * @author ranx
 * @create 2018-08-20 17:07
 **/
public interface Strategy {
    //判断两个元素是否相等
    public boolean equals(Object obj1, Object obj2);

    public int compare(Object obj1, Object obj2);
}
