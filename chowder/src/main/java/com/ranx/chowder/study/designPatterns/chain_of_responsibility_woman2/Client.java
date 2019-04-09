package com.ranx.chowder.study.designPatterns.chain_of_responsibility_woman2;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author ranx
 * @create 2019-04-08 14:48
 **/
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            arrayList.add(new Woman(random.nextInt(4), "我要出去逛街"));
        }

        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        //定义请示顺序
        father.setNext(husband);
        husband.setNext(son);

        for (IWomen women : arrayList) {
            father.handleMessage(women);
        }
    }
}
