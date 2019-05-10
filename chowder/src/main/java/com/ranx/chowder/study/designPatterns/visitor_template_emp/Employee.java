package com.ranx.chowder.study.designPatterns.visitor_template_emp;

/**
 * 抽象员工
 * @author ranx
 * @create 2019-04-30 9:38
 **/
public abstract class Employee {
    public final static int MALE = 0;
    public final static int FEMALE = 1;

    private String name;
    private int salary;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public final void report() {
        String info = "姓名: " + this.name + "\t"
                + "性别：" + (this.sex == FEMALE ? "女" : "男") + "\t"
                + "薪水：" + this.salary + "\t";
        info = info + this.getOtherInfo();
        System.out.println(info);
    }

    protected  abstract String getOtherInfo();
}
