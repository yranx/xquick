package com.ranx.chowder.designPatterns.chain_of_responsibility_woman;

/**
 * 有处理权的人员接口
 * @author ranx
 * @create 2019-04-08 14:30
 **/
public interface IHandler {
    //女性的请求，需要处理下
    public void handleMessage(IWomen women);
}
