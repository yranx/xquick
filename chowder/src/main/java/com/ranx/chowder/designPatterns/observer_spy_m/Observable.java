package com.ranx.chowder.designPatterns.observer_spy_m;


/**
 * 被观察者接口
 * @author ranx
 * @create 2019-04-25 18:53
 **/
public interface Observable {
    //增加一个观察者
    public void addObserver(Observer observer);

    //删除一个观察者
    public void deleteObserver(Observer observer);

    //有动作，通知观察者
    public void notifyObservers(String context);
}
