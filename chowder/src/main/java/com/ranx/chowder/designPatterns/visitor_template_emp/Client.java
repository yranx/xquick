package com.ranx.chowder.designPatterns.visitor_template_emp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranx
 * @create 2019-04-30 9:57
 **/
public class Client {
    public static void main(String[] args) {
        for (Employee emp : mockEmployee()) {
            emp.report();
        }
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
