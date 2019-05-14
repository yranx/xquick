package com.ranx.chowder.study.designPatterns.state_lift_state;

/**
 * @author ranx
 * @create 2019-05-13 10:24
 **/
public class Client {
    public static void main(String[] args) {
        ILift lift = new Lift();
        lift.setState(ILift.STOPPING_STATE);
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
