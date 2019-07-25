package com.ranx.chowder.designPatterns.visitor_statistical;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ranx
 * @create 2019-04-30 9:57
 **/
public class Client {
    public static void main(String[] args) {
        IVisitor visitor = new Visitor();
        for (Employee emp : mockEmployee()) {
            emp.accept(visitor);
        }

        //具体类里面没有赋值
        System.out.println("本公司的月工资总额是：" + visitor.getTotalSalary());
    }

    //模拟数据表
    public static List<Employee> mockEmployee() {
        List<Employee> employeeList = new ArrayList<Employee>();
        CommonEmployee zhangsan = new CommonEmployee();
        zhangsan.setJob("编程");
        zhangsan.setName("张三");
        zhangsan.setSalary(1800);
        zhangsan.setSex(Employee.MALE);
        employeeList.add(zhangsan);

        CommonEmployee lisi = new CommonEmployee();
        lisi.setJob("美工");
        lisi.setName("李四");
        lisi.setSalary(1900);
        lisi.setSex(Employee.FEMALE);
        employeeList.add(lisi);

        Manager wangwu = new Manager();
        wangwu.setPerformance("经理");
        wangwu.setName("王五");
        wangwu.setSalary(18750);
        wangwu.setSex(Employee.MALE);
        employeeList.add(wangwu);

        return employeeList;
    }
}
