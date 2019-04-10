package com.ranx.chowder.study.designPatterns.decorator_grade_dect;



/**
 * 老爸查看成绩单
 * @author ranx
 * @create 2019-04-10 11:35
 **/
public class Father {

    public static void main(String[] args) {
        SchoolReport sr = new FouthGradeSchoolReport();

        sr = new HighScoreDecorator(sr);
        sr = new SortDecorator(sr);
        //看成绩
        sr.report();
        sr.sign("签名，，，");
    }
}
