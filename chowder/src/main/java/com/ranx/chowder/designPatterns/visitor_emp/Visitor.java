package com.ranx.chowder.designPatterns.visitor_emp;

/**
 * 访问者实现
 * @author ranx
 * @create 2019-04-30 10:42
 **/
public class Visitor implements IVisitor{
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(this.getCommonEmployee(commonEmployee));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(this.getManagerInfo(manager));
    }

    //基本信息
    private String getBasicInfo(Employee employee) {
        String info = "姓名: " + employee.getName() + "\t"
                + "性别：" + (employee.getSex() == employee.FEMALE ? "女" : "男") + "\t"
                + "薪水：" + employee.getSalary() + "\t";
        return info;
    }

    //组装部门经理
    private String getManagerInfo(Manager manager) {
        String otherInfo = "业绩：" + manager.getPerformance() + "\t";
        return this.getBasicInfo(manager) + otherInfo;
    }

    //组装普通员工信息
    private String getCommonEmployee(CommonEmployee commonEmployee){
        String otherInfo = "工作：" + commonEmployee.getJob() + "\t";
        return this.getBasicInfo(commonEmployee) + otherInfo;
    }
}
