package com.ranx.chowder.study.designPatterns.bridge_corp;

/**
 * 抽象公司
 * @author ranx
 * @create 2019-06-11 19:21
 **/
public abstract class Corp {
    //生产
    protected abstract void produce();
    //销售
    protected abstract void sell();
    //盈利
    public void makeMoney(){
        this.produce();
        this.sell();
    }
}
