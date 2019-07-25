package com.ranx.chowder.designPatterns.visitor_statistical;



/**
 * 抽象访问者
 * @author ranx
 * @create 2019-05-08 19:09
 **/
public interface IVisitor {
    //可以访问的对象
    public void visit(CommonEmployee commonEmployee);
    public void visit(Manager manager);

    //统计所有员工工资总和
    public int getTotalSalary();

}
