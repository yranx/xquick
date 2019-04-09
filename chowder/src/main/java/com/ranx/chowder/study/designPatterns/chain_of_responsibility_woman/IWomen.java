package com.ranx.chowder.study.designPatterns.chain_of_responsibility_woman;

/**
 * 女性接口
 * @author ranx
 * @create 2019-04-08 14:12
 **/
public interface IWomen {
    //获得个人状况
    public int getType();
    //获得个人请示
    public String getRequest();
}
