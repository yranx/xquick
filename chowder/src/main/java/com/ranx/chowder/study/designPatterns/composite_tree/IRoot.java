package com.ranx.chowder.study.designPatterns.composite_tree;

import java.util.ArrayList;

/**
 * 根节点接口
 * @author ranx
 * @create 2019-04-19 16:01
 **/
public interface IRoot {
    public String getInfo();

    //增加树枝节点
    public void add(IBranch branch);
    //增加树叶节点
    public void add(ILeaf leaf);
    //遍历
    public ArrayList getSubordinateInfo();
}
