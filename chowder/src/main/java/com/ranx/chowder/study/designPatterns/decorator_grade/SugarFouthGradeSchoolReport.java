package com.ranx.chowder.study.designPatterns.decorator_grade;

/**
 * 修饰成绩单
 * @author ranx
 * @create 2019-04-10 15:06
 **/
public class SugarFouthGradeSchoolReport extends FouthGradeSchoolReport{
    //定义要美化的方法
    private void reportHighScore(){
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    //汇报排名
    private void reportSort() {
        System.out.println("我是排名第37名...");
    }

    //汇报内容已发生变化，故要重写父类
    @Override
    public void report() {
        this.reportHighScore();
        super.report(); //看成绩单
        this.reportSort();
    }
}
