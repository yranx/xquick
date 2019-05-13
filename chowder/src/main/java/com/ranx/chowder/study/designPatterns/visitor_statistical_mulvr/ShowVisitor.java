package com.ranx.chowder.study.designPatterns.visitor_statistical_mulvr;


/**
 * @author ranx
 * @create 2019-05-10 16:28
 **/
public class ShowVisitor implements IShowVisitor {
    private String info = "";

    @Override
    public void report() {
        System.out.println(this.info);
    }

    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.info = this.info + this.getBasicInfo(commonEmployee)
                + "工作：" + commonEmployee.getJob() + "\t\n";
    }

    @Override
    public void visit(Manager manager) {
        this.info = this.info + this.getBasicInfo(manager)
                + "业绩：" + manager.getPerformance() + "\t\n";
    }


    //基本信息
    private String getBasicInfo(Employee employee) {
        String info = "姓名: " + employee.getName() + "\t"
                + "性别：" + (employee.getSex() == employee.FEMALE ? "女" : "男") + "\t"
                + "薪水：" + employee.getSalary() + "\t";
        return info;
    }

}
