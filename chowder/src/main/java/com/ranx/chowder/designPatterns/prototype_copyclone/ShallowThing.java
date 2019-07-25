package com.ranx.chowder.designPatterns.prototype_copyclone;

import java.util.ArrayList;

/**
 * 浅拷贝
 * @author ranx
 * @create 2019-03-26 14:39
 **/
public class ShallowThing implements Cloneable{
    //定义一个私有变量
    private  ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    public ShallowThing clone(){
        ShallowThing shallowThing = new ShallowThing();
        try {
            shallowThing = (ShallowThing) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return shallowThing;
    }

    //设置HashMap的值
    public void setValue(String value) {
        this.arrayList.add(value);
    }

    //取得arrayList的值
    public ArrayList<String> getValue() {
        return this.arrayList;
    }
}
