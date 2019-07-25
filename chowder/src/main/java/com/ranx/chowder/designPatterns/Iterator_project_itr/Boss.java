package com.ranx.chowder.designPatterns.Iterator_project_itr;

import java.util.ArrayList;

/**
 * 老大看报表
 * @author ranx
 * @create 2019-04-15 9:23
 **/
public class Boss {
    public static void main(String[] args) {
        //定义一个LIst,存放所有的项目对象
        IProject project = new Project();
        //增加星球大战项目
        project.add("星球大战项目", 10, 10000);
        project.add("扭转时空项目", 100, 10000000);
        project.add("超人改造项目", 10000, 1000000000);
        for (int i=4; i<104; i++) {
            project.add("第" + i + "个项目", i*5, i*1000000);
        }

        //遍历，取出所有数据
        IProjectIterator projectIterator = project.iterator();
        while (projectIterator.hasNext()) {
            IProject p = (IProject) projectIterator.next();
            System.out.println(p.getProjectInfo());
        }
    }
}
