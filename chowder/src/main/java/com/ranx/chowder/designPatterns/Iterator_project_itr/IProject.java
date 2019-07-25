package com.ranx.chowder.designPatterns.Iterator_project_itr;

/**
 * 项目信息接口
 * @author ranx
 * @create 2019-04-15 9:08
 **/
public interface IProject {
    //增加项目
    public void add(String name, int num, int cost);
    //从老板这里能看到的就是项目信息
    public String getProjectInfo();
    //获得一个可以被遍历的对象
    public IProjectIterator iterator();
}
