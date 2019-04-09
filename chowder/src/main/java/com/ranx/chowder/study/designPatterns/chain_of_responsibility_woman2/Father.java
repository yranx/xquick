package com.ranx.chowder.study.designPatterns.chain_of_responsibility_woman2;

/**
 * 父亲类
 * @author ranx
 * @create 2019-04-08 14:31
 **/
public class Father extends Handler {

    //定义自己能够处理的等级的级别
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("女儿向父亲的请示是： " + women.getRequest());
        System.out.println("父亲的答复是： 同意");
    }
}
