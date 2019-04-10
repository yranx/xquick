package com.ranx.chowder.study.designPatterns.decorator_grade_dect;

/**
 * 修饰的抽象类
 * @author ranx
 * @create 2019-04-10 15:55
 **/
public abstract class Decorator extends SchoolReport{
    private SchoolReport sr;
    //构造函数，传递成绩单过来
    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    @Override
    public void report() {
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}
