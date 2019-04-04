package com.ranx.chowder.study.designPatterns.prototype_copyclone;

import java.util.ArrayList;

/**
 * 深拷贝
 * @author ranx
 * @create 2019-03-26 16:22
 **/
public class DeepThing implements Cloneable{
    //定义一个私有变量
    private ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    public DeepThing clone(){
        DeepThing deepThing = null;
        try {
            deepThing = (DeepThing) super.clone();
            //对私有的类变量进行独立的拷贝
            deepThing.arrayList = (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return deepThing;
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
