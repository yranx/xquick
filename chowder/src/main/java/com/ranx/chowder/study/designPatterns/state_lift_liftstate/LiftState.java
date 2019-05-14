package com.ranx.chowder.study.designPatterns.state_lift_liftstate;

/**
 * 抽象电梯状态
 * @author ranx
 * @create 2019-05-14 18:35
 **/
public abstract class LiftState {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }


    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}
