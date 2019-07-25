package com.ranx.chowder.designPatterns.state_lift;

/**
 * @author ranx
 * @create 2019-05-13 10:24
 **/
public class Client {
    public static void main(String[] args) {
        ILift lift = new Lift();
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
