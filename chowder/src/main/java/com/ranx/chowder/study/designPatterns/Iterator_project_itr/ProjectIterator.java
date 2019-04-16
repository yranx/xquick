package com.ranx.chowder.study.designPatterns.Iterator_project_itr;

import java.util.ArrayList;

/**
 * @author ranx
 * @create 2019-04-16 16:05
 **/
public class ProjectIterator implements IProjectIterator {
    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    private int currentItem = 0;

    //构造函数传入projecList
    public ProjectIterator(ArrayList<IProject> projectList) {
        this.projectList = projectList;
    }

    //判断是否还有元素，必须实现
    public boolean hasNext() {
        boolean b = true;
        if (this.currentItem >= projectList.size() ||
                this.projectList.get(this.currentItem) == null) {
            b = false;
        }
        return b;
    }


    public IProject next() {
        return (IProject) this.projectList.get(this.currentItem++);
    }

    @Override
    public void remove() {
        //暂时没有使用到
    }
}
