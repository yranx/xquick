package com.ranx.chowder.study.designPatterns.visitor_statistical;

/**
 * @author ranx
 * @create 2019-04-30 9:45
 **/
public class CommonEmployee extends Employee {
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
