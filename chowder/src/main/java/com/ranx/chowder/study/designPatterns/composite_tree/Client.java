package com.ranx.chowder.study.designPatterns.composite_tree;

import java.util.ArrayList;

/**
 * 场景类
 * @author ranx
 * @create 2019-04-21 9:19
 **/
public class Client {

    public static void main(String[] args) {
        //先产生一个根节点
        IRoot ceo = new Root("赵大", "总经理", 100000);
        //产生树枝节点：三个部门经理
        IBranch developDep = new Branch("钱二", "研发部门经理", 10000);
        IBranch salesDep = new Branch("孙三", "销售部门经理", 20000);
        IBranch financeDep = new Branch("李四", "财务部经理", 30000);
        //产生两个小组长
        IBranch firstDevGroup = new Branch("周五", "开发一组组长", 5000);
        IBranch secondDevGroup = new Branch("吴六", "开发二组组长", 6000);
        ILeaf zhengqi = new Leaf("郑七", "研发部副总", 20000);
        //小职员
        ILeaf a = new Leaf("a", "开发人员", 2000);
        ILeaf b = new Leaf("b", "开发人员", 2000);
        ILeaf c = new Leaf("c", "开发人员", 2000);
        ILeaf d = new Leaf("d", "开发人员", 2000);
        ILeaf e = new Leaf("e", "开发人员", 2000);
        ILeaf f = new Leaf("f", "开发人员", 2000);
        ILeaf g = new Leaf("g", "开发人员", 2000);
        ILeaf h = new Leaf("h", "销售人员", 5000);
        ILeaf i = new Leaf("i", "销售人员", 4000);
        ILeaf j = new Leaf("j", "财务人员", 5000);
        ILeaf k = new Leaf("k", "ceo秘书", 8000);

        //生产出各种人，下面进行组装
        //首先是定义总经理下有三个部门经理
        ceo.add(developDep);
        ceo.add(salesDep);
        ceo.add(financeDep);
        ceo.add(k);
        //定义研发部门下的结构
        developDep.add(firstDevGroup);
        developDep.add(secondDevGroup);
        developDep.add(zhengqi);
        //开发小组
        firstDevGroup.add(a);
        firstDevGroup.add(b);
        firstDevGroup.add(c);
        secondDevGroup.add(d);
        secondDevGroup.add(e);
        secondDevGroup.add(f);
        //销售部
        salesDep.add(h);
        salesDep.add(i);
        //财务
        financeDep.add(j);
        //打印树状结构
        System.out.println(ceo.getInfo());
        //打印整个树形
        getAllSubordinateInfo(ceo.getSubordinateInfo());
    }

    //遍历所有的树枝节点，打印出信息
    private static void getAllSubordinateInfo(ArrayList subordinateList) {
        int length = subordinateList.size();
        for (int m=0; m<length; m++) {
            Object s = subordinateList.get(m);
            if (s instanceof Leaf) {//叶子节点，就是员工
                ILeaf employee = (ILeaf) s;
                System.out.println(((Leaf) s).getInfo());
            } else {
                IBranch branch = (IBranch) s;
                System.out.println(branch.getInfo());
                //再递归调用
                getAllSubordinateInfo(branch.getSubordinateInfo());
            }
        }
    }
}
