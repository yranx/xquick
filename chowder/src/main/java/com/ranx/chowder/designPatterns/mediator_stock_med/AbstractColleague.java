package com.ranx.chowder.designPatterns.mediator_stock_med;


/**
 * 抽象事情类
 * @author ranx
 * @create 2019-04-04 10:52
 **/
public abstract class AbstractColleague {
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
