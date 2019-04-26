package com.ranx.chowder.study.designPatterns.observer_normal;

import java.util.Vector;

/**
 * 被观察者
 * @author ranx
 * @create 2019-04-25 19:20
 **/
public abstract class Subject {
    private Vector<Observer> obsVector = new Vector<Observer>();

    public void addObserver(Observer o) {
        this.obsVector.add(o);
    }

    public void delObserver(Observer o) {
        this.obsVector.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : this.obsVector) {
            o.update();
        }
    }
}
