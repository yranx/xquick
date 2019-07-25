package com.ranx.chowder.designPatterns.chain_of_responsibility_woman;

/**
 * 丈夫类
 * @author ranx
 * @create 2019-04-08 14:35
 **/
public class Husband implements IHandler{
    //既嫁从夫
    @Override
    public void handleMessage(IWomen women) {
        System.out.println("妻子的请示是： " + women.getRequest());
        System.out.println("丈夫的答复是： 同意");
    }
}
