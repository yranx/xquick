package com.ranx.chowder.study.designPatterns.composite_tree_m2;

import java.util.ArrayList;

/**
 * 树枝节点
 * @author ranx
 * @create 2019-04-21 9:16
 **/
public class Branch extends Corp {
    //领导的下属
    ArrayList<Corp> suborfinateList = new ArrayList<Corp>();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    //增加一个下属
    public void addSubordinate(Corp corp) {
        this.suborfinateList.add(corp);
    }

    //查询下属
    public ArrayList<Corp> getSuborfinate() {
        return this.suborfinateList;
    }
}
