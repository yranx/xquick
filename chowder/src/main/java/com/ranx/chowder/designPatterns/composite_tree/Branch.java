package com.ranx.chowder.designPatterns.composite_tree;

import java.util.ArrayList;

/**
 * 分支的节点实现
 * @author ranx
 * @create 2019-04-19 16:22
 **/
public class Branch implements IBranch {
    //存储子节点的信息
    private ArrayList subordinateList = new ArrayList();
    //树枝节点的名称
    private String name = "";
    //树枝节点的职位
    private String position = "";
    //树枝节点的薪水
    private int salary = 0;

    //通过构造函数传递树枝节点的参数
    public Branch(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }


    @Override
    public String getInfo() {
        String info = "";
        info = "名称：" + this.name
                + "\t职位:" + this.position
                + "\t薪水:" + this.salary;
        return info;
    }

    //增加一个子树枝节点
    @Override
    public void add(IBranch branch) {
        this.subordinateList.add(branch);

    }

    //增加一个叶子节点
    @Override
    public void add(ILeaf leaf) {
        this.subordinateList.add(leaf);
    }

    @Override
    public ArrayList getSubordinateInfo() {
        return this.subordinateList;
    }
}
