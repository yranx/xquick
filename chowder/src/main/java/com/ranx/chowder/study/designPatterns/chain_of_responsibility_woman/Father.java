package com.ranx.chowder.study.designPatterns.chain_of_responsibility_woman;

/**
 * 父亲类
 * @author ranx
 * @create 2019-04-08 14:31
 **/
public class Father implements IHandler{
    //未嫁从父
    @Override
    public void handleMessage(IWomen women) {
        System.out.println("女儿的请示是： " + women.getRequest());
        System.out.println("父亲的答复是： 同意");
    }
}
