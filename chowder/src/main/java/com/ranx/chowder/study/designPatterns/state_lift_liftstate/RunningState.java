package com.ranx.chowder.study.designPatterns.state_lift_liftstate;

/**
 * @author ranx
 * @create 2019-05-14 18:42
 **/
public class RunningState extends LiftState {
    @Override
    public void open() {
        //do nothing
    }

    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void run() {
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
