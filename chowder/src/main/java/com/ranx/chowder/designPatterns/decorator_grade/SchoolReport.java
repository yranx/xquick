package com.ranx.chowder.designPatterns.decorator_grade;

/**
 * 抽象成绩单
 * @author ranx
 * @create 2019-04-09 10:22
 **/
public abstract class SchoolReport {
    //成绩情况
    public abstract void report();

    //家长签字
    public abstract void sign(String name);
}
