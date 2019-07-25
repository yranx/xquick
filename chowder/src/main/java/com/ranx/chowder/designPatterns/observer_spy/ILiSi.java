package com.ranx.chowder.designPatterns.observer_spy;

/**
 * 抽象观察者
 * @author ranx
 * @create 2019-04-25 9:56
 **/
public interface ILiSi {
    //别人有动静，自己也要动
    public void update(String context);
}
