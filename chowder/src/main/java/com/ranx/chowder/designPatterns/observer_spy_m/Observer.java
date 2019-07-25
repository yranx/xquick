package com.ranx.chowder.designPatterns.observer_spy_m;

/**
 * 观察者接口
 * @author ranx
 * @create 2019-04-25 9:56
 **/
public interface Observer {
    //别人有动静，自己也要动
    public void update(String context);
}
