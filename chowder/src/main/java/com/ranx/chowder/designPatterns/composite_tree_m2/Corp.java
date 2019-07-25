package com.ranx.chowder.designPatterns.composite_tree_m2;

/**
 * 抽象公司职员类
 * @author ranx
 * @create 2019-04-21 16:05
 **/
public abstract class Corp {
    private String name = "";
    private String position = "";
    private int salary = 0;

    public Corp(String name, String position, int salary) {
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
}
