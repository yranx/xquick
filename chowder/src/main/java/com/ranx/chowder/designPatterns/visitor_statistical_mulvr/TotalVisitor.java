package com.ranx.chowder.designPatterns.visitor_statistical_mulvr;

/**
 * @author ranx
 * @create 2019-05-10 16:28
 **/
public class TotalVisitor implements ITotalVisitor {
    //工资系数
    private final static int MANAGER_COEFFOCOENT = 5;
    private final static int COMMONEMPLOYEE_COEFFOCIENT = 2;
    //工资总和
    private int commonTotalSalary = 0;
    private int managerTotalSalary = 0;

    @Override
    public void totalSalary() {
        System.out.println("本公司的月工资总额是" + (this.commonTotalSalary + this.managerTotalSalary));
    }

    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.commonTotalSalary = this.commonTotalSalary + commonEmployee.getSalary() * COMMONEMPLOYEE_COEFFOCIENT;
    }

    @Override
    public void visit(Manager manager) {
        this.managerTotalSalary = this.managerTotalSalary + manager.getSalary() * MANAGER_COEFFOCOENT;
    }


    //基本信息
    private String getBasicInfo(Employee employee) {
        String info = "姓名: " + employee.getName() + "\t"
                + "性别：" + (employee.getSex() == employee.FEMALE ? "女" : "男") + "\t"
                + "薪水：" + employee.getSalary() + "\t";
        return info;
    }


}
