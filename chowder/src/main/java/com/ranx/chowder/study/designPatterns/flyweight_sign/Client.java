package com.ranx.chowder.study.designPatterns.flyweight_sign;

/**
 * @author ranx
 * @create 2019-05-25 21:31
 **/
public class Client {
    public static void main(String[] args) {
        //从工厂中获得一个对象
        SignInfo signInfo = SignInfoFactory.getSignInfo();
        //进行其他业务处理
    }
}
