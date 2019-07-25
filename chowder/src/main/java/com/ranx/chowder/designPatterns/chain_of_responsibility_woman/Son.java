package com.ranx.chowder.designPatterns.chain_of_responsibility_woman;

/**
 * 儿子类
 * @author ranx
 * @create 2019-04-08 14:35
 **/
public class Son implements IHandler{

    @Override
    public void handleMessage(IWomen women) {
        System.out.println("母亲的请示是： " + women.getRequest());
        System.out.println("儿子的答复是： 同意");
    }
}
