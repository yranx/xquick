package com.ranx.chowder.study.designPatterns.command_group;

/**
 * 场景类
 * @author ranx
 * @create 2019-04-04 15:50
 **/
public class Client {

    public static void main(String[] args) {
        System.out.println("-------------------客户要求增加一项需求------------------");
        Group rg = new RequirementGroup();
        rg.find();
        rg.add();
        rg.plan();
    }
}
