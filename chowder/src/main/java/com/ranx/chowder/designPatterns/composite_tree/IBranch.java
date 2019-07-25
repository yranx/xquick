package com.ranx.chowder.designPatterns.composite_tree;

import java.util.ArrayList;

/**
 * 其他有分支的节点接口
 * @author ranx
 * @create 2019-04-19 16:17
 **/
public interface IBranch {
    public String getInfo();
    //增加数据节点
    public void add(IBranch branch);
    //增加叶子节点
    public void add(ILeaf leaf);
    //获得下级信息
    public ArrayList getSubordinateInfo();
}
