package com.ranx.chowder.study.designPatterns.flyweight_sign;

/**
 * 报考信息工厂
 * @author ranx
 * @create 2019-05-25 21:29
 **/
public class SignInfoFactory {
    public static SignInfo getSignInfo() {
        return new SignInfo();
    }
}
