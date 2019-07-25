package com.ranx.chowder.designPatterns.chain_of_responsibility_woman2;

/**
 * 儿子类
 * @author ranx
 * @create 2019-04-08 14:35
 **/
public class Son extends Handler {

    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("母亲向儿子的询问是： " + women.getRequest());
        System.out.println("儿子的答复是： 同意");
    }
}
