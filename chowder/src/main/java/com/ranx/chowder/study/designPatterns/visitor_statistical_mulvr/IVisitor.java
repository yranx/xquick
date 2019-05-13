package com.ranx.chowder.study.designPatterns.visitor_statistical_mulvr;

/**
 * 抽象访问者
 * @author ranx
 * @create 2019-05-08 19:09
 **/
public interface IVisitor {
    //可以访问的对象
    public void visit(CommonEmployee commonEmployee);
    public void visit(Manager manager);


}
