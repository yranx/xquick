package com.ranx.chowder.designPatterns.composite_tree_m;

import java.util.ArrayList;

/**
 * 树枝的实现类
 * @author ranx
 * @create 2019-04-19 16:22
 **/
public class Branch implements IBranch {
    //树枝节点的名称
    private String name = "";
    //树枝节点的职位
    private String position = "";
    //树枝节点的薪水
    private int salary = 0;
    //存储子节点的信息
    ArrayList<ICorp> subordinateList = new ArrayList<ICorp>();
    //通过构造函数传递树枝节点的参数
    public Branch(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getInfo() {
        String info = "";
        info = "名称：" + this.name
                + "\t职位:" + this.position
                + "\t薪水:" + this.salary;
        return info;
    }

    //增加下属
    @Override
    public void addSubordinate(ICorp corp) {
        this.subordinateList.add(corp);
    }

    @Override
    public ArrayList<ICorp> getSubordinate() {
        return subordinateList;
    }
}
