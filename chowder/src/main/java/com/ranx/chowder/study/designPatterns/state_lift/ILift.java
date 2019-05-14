package com.ranx.chowder.study.designPatterns.state_lift;

/**
 * 电梯接口
 * @author ranx
 * @create 2019-05-13 10:16
 **/
public interface ILift {
    public void open();
    public void close();
    public void run();
    public void stop();
}
