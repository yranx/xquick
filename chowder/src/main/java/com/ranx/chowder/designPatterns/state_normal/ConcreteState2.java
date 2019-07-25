package com.ranx.chowder.designPatterns.state_normal;


/**
 * @author ranx
 * @create 2019-05-14 19:22
 **/
public class ConcreteState2 extends State {
    @Override
    public void handle1() {
        //设置当前状态为stat1
        super.context.setCurrentState(Context.STATE1);
        //过渡到state2状态，由Context实现
        super.context.handle1();

    }

    @Override
    public void handle2() {
        //本状态下必须处理的逻辑
    }
}
