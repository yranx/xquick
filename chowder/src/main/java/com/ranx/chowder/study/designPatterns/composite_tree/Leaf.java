package com.ranx.chowder.study.designPatterns.composite_tree;

/**
 * @author ranx
 * @create 2019-04-21 9:16
 **/
public class Leaf implements ILeaf {
    private String name = "";
    private String position = "";
    private int salary=0;

    public Leaf(String name, String position, int salary) {
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
}
