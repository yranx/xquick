package com.ranx.chowder.study.designPatterns.bridge_corp_copy;

/**
 * 抽象公司
 * @author ranx
 * @create 2019-06-11 19:21
 **/
public abstract class Corp {
    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    //盈利
    public void makeMoney(){
        this.product.beProducted();
        this.product.beSelled();
    }
}
