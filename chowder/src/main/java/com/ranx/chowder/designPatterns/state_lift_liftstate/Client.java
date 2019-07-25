package com.ranx.chowder.designPatterns.state_lift_liftstate;


/**
 * @author ranx
 * @create 2019-05-13 10:24
 **/
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        //只要定义一个电梯的初始状态
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
