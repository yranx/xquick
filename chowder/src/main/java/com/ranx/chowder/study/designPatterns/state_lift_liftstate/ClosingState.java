package com.ranx.chowder.study.designPatterns.state_lift_liftstate;

/**
 * @author ranx
 * @create 2019-05-14 18:42
 **/
public class ClosingState extends LiftState {
    //门关了再开
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("Lift close");
    }

    //关门运行
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    //门关着，没按着楼层
    @Override
    public void stop() {
        System.out.println("Lift stop");
    }
}
