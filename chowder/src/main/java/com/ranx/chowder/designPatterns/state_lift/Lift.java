package com.ranx.chowder.designPatterns.state_lift;

/**
 * 电梯
 * @author ranx
 * @create 2019-05-13 10:21
 **/
public class Lift implements ILift {
    @Override
    public void open() {
        System.out.println("Lift open");
    }

    @Override
    public void close() {
        System.out.println("Lift close");
    }

    @Override
    public void run() {
        System.out.println("Lift run");
    }

    @Override
    public void stop() {
        System.out.println("Lift stop");
    }
}
