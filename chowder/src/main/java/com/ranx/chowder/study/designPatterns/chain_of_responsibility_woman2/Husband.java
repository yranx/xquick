package com.ranx.chowder.study.designPatterns.chain_of_responsibility_woman2;

/**
 * 丈夫类
 * @author ranx
 * @create 2019-04-08 14:35
 **/
public class Husband extends Handler {

    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("妻子向丈夫的请示是： " + women.getRequest());
        System.out.println("丈夫的答复是： 同意");
    }
}
