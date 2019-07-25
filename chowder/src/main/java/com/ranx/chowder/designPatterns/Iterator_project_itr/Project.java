package com.ranx.chowder.designPatterns.Iterator_project_itr;

import java.util.ArrayList;

/**
 * 项目信息
 * @author ranx
 * @create 2019-04-15 9:10
 **/
public class Project implements IProject {
    //定义一个项目列表
    private ArrayList<IProject> projectList = new ArrayList<IProject>();

    //项目名
    private String name = "";
    //项目成员数量
    private int num = 0;
    //费用
    private int cost = 0;

    public Project() {
    }

    //定义一个构造函数，把所有老板需要看到的信息存储起来
    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public void add(String name, int num, int cost) {
        this.projectList.add(new Project(name, num, cost));
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        info = info + "项目名称是：" + this.name;
        info = info + "\t项目人数：" + this.num;
        info = info + "\t项目费用：" + this.cost;
        return info;
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
