package com.ranx.chowder.study.designPatterns.composite_tree;

import java.util.ArrayList;

/**
 * 根节点的实现
 * @author ranx
 * @create 2019-04-19 16:05
 **/
public class Root implements IRoot{
    //保存根节点下的树枝节点和树叶节点，Subordinate表示下级
    private ArrayList subordinateList = new ArrayList();
    //根节点的名称
    private String name = "";
    //根节点的职位
    private String position = "";
    //根节点的薪水
    private int salary = 0;
    //通过构造函数传递进来总经理的信息
    public Root(String name, String position, int salary) {
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


    @Override
    public void add(IBranch branch) {
        this.subordinateList.add(branch);
    }

    @Override
    public void add(ILeaf leaf) {
        this.subordinateList.add(leaf);
    }

    @Override
    public ArrayList getSubordinateInfo() {
        return this.subordinateList;
    }
}
