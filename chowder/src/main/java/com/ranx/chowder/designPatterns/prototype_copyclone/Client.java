package com.ranx.chowder.designPatterns.prototype_copyclone;

/**
 * @author ranx
 * @create 2019-03-26 15:02
 **/
public class Client {

    public static void main(String[] args) {
        /**
         * 浅拷贝测试
         */
//        ShallowThing shallowThing = new ShallowThing();
//        shallowThing.setValue("张三");
//        //拷贝一个对象
//        ShallowThing cloneThing = shallowThing.clone();
//        cloneThing.setValue("李四");
//        System.out.println(cloneThing.getValue());

        /**
         * 深拷贝测试
         */
        DeepThing deepThing = new DeepThing();
        deepThing.setValue("张三");
        //拷贝一个对象
        DeepThing cloneDeepThing = deepThing.clone();
        cloneDeepThing.setValue("李四");
        System.out.println(cloneDeepThing.getValue());
    }
}
