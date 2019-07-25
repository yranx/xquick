package com.ranx.chowder.designPatterns.visitor_emp;

/**
 * 访问者接口
 * @author ranx
 * @create 2019-04-30 10:35
 **/
public interface IVisitor {
    //访问普通员工
    public void visit(CommonEmployee commonEmployee);
    //访问部门经理
    public void visit(Manager manager);
}
