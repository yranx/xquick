package com.ranx.chowder.designPatterns.decorator_grade_dect;

/**
 * 排名情况修饰
 * @author ranx
 * @create 2019-04-10 16:13
 **/
public class SortDecorator extends Decorator{
    //构造函数
    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    //告知排名
    private void reportSort() {
        System.out.println("我是排名第37名...");
    }

    //看完成绩单，再告诉
    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
