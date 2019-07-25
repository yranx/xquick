package com.ranx.chowder.designPatterns.visitor_statistical_mulvr;


/**
 * 管理层
 * @author ranx
 * @create 2019-04-30 9:53
 **/
public class Manager extends Employee {
    //职责
    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
