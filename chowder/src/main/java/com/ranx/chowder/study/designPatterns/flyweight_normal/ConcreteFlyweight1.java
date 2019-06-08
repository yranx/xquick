package com.ranx.chowder.study.designPatterns.flyweight_normal;

/**
 * @author ranx
 * @create 2019-06-06 18:58
 **/
public class ConcreteFlyweight1 extends Flyweight {
    //接受外部状态
    public ConcreteFlyweight1(String extrinsic) {
        super(extrinsic);
    }

    //根据外部状态进行逻辑处理
    public void operate() {
        //业务逻辑
    }
}
