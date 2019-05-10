package com.ranx.chowder.study.designPatterns.visitor_template_emp;

/**
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
    protected String getOtherInfo() {
        return "业绩：" + this.performance;
    }
}
