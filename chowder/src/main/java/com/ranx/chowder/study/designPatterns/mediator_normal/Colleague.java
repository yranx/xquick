package com.ranx.chowder.study.designPatterns.mediator_normal;

/**
 * 抽象同事类
 * @author ranx
 * @create 2019-04-04 14:24
 **/
public abstract class Colleague {
    protected  Mediator mediator;
    public Colleague (Mediator mediator) {
        this.mediator = mediator;
    }
}
