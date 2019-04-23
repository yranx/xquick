package com.ranx.chowder.study.designPatterns.composite_tree_m;

import com.ranx.chowder.study.designPatterns.composite_tree.ILeaf;

import java.util.ArrayList;

/**
 * 其他有分支的节点接口
 * @author ranx
 * @create 2019-04-19 16:17
 **/
public interface IBranch extends ICorp{
    //增加节点(树叶或者是经理)
    public void addSubordinate(ICorp corp);

    //获得下级信息
    public ArrayList<ICorp> getSubordinate();
}
