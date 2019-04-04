package com.ranx.chowder.study.designPatterns.prototype_normal;

/**
 * 原型模式
 * @author ranx
 * @create 2019-03-26 14:13
 **/
public class PrototypeClass implements Cloneable{
    @Override
    public PrototypeClass clone(){
        PrototypeClass prototypeClass = null;
        try {
            prototypeClass = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            //异常处理
        }
        return prototypeClass;
    }
}
