package com.ranx.chowder.study.designPatterns.state_lift_liftstate;

/**
 * 开门状态
 * @author ranx
 * @create 2019-05-14 18:42
 **/
public class OpenningState extends LiftState {
    @Override
    public void open() {
        System.out.println("Lift open");
    }
    //门开了可以关
    @Override
    public void close() {
        //修改状态
        super.context.setLiftState(Context.closingState);
        //动作委托执行
        super.context.getLiftState().close();
    }


    @Override
    public void run() {
        //do nothing
    }


    @Override
    public void stop() {
        //开门当然是停止
    }
}
