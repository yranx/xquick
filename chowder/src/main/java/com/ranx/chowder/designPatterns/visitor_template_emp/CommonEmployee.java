package com.ranx.chowder.designPatterns.visitor_template_emp;

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
    protected String getOtherInfo() {
        return "工作：" + this.job + "\t";
    }
}
