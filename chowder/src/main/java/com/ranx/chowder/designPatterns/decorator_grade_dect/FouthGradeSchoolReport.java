package com.ranx.chowder.designPatterns.decorator_grade_dect;

/**
 * 四年级成绩单
 * @author ranx
 * @create 2019-04-09 15:28
 **/
public class FouthGradeSchoolReport extends SchoolReport{
    @Override
    public void report() {
        System.out.println("尊敬的XXX家长：");
        System.out.println(".......................");
        System.out.println("语文 62 数学65 体育98 自然63");
        System.out.println(".......................");
        System.out.println("                    家长签名：       ");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名为：" + name);
    }
}
