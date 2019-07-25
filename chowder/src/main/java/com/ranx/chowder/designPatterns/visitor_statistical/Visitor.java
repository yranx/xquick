package com.ranx.chowder.designPatterns.visitor_statistical;

/**
 * 访问者实现
 * @author ranx
 * @create 2019-04-30 10:42
 **/
public class Visitor implements IVisitor{
    //工资系数
    private final static int MANAGER_COEFFOCOENT = 5;
    private final static int COMMONEMPLOYEE_COEFFOCIENT = 2;
    //工资总和
    private int commonTotalSalary = 0;
    private int managerTotalSalary = 0;


    //计算
    private void calManagerSalary(int salary) {
        this.managerTotalSalary = this.managerTotalSalary + salary * MANAGER_COEFFOCOENT;
    }

    private void calCommonSalary(int salary) {
        this.commonTotalSalary = this.commonTotalSalary + salary * COMMONEMPLOYEE_COEFFOCIENT;
    }

    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(this.getCommonEmployee(commonEmployee));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(this.getManagerInfo(manager));
    }


    @Override
    public int getTotalSalary() {
        return this.commonTotalSalary + this.managerTotalSalary;
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
