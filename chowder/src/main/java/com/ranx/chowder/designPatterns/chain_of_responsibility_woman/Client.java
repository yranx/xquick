package com.ranx.chowder.designPatterns.chain_of_responsibility_woman;

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
        IHandler father = new Father();
        IHandler husband = new Husband();
        IHandler son = new Son();

        for (IWomen women : arrayList) {
            if (women.getType() == 1) {
                System.out.println("---------女儿向父亲请示----------");
                father.handleMessage(women);
            } else if(women.getType() == 2) {
                System.out.println("---------妻子向丈夫请示----------");
                husband.handleMessage(women);
            } else if (women.getType() == 3){
                System.out.println("---------母亲问下儿子----------");
                son.handleMessage(women);
            } else {
                System.out.println("do nothing");
                //do nothing
            }
        }
    }
}
