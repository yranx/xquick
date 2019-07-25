package com.ranx.chowder.designPatterns.decorator_grade_dect;

/**
 * @author ranx
 * @create 2019-04-10 16:08
 **/
public class HighScoreDecorator extends Decorator{
    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    //汇报最高成绩
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
