package com.ranx.chowder.study;

import java.lang.reflect.Constructor;

/**
 * 内部类：增强类与类的耦合关系
 * 获取内部类的几种方式
 * @author ranx
 * @create 2018-11-21 16:22
 **/
public class InnerClassStudy {
    //1.内部类设为静态类
    public static class InnerClazO {
        public void run() {
            System.out.println("run.....one");
        }
    }

    //2.实例化对象后调用public方法
    class InnerClazS{
        public void run() {
            System.out.println("run.....two");
        }
    }
    public InnerClazS getInnerClass() {
        InnerClazS innerClazS = new InnerClazS();
        return innerClazS;
    }

    //3.直接实例化
    public  class InnerClaT{
        public void run() {
            System.out.println("run.....three");
        }
    }

    public static void main(String[] args) {
        InnerClazO innerClaz = new InnerClazO();
        innerClaz.run();

        InnerClassStudy innerClassStudy = new InnerClassStudy();
        InnerClazS innerClazS = innerClassStudy.getInnerClass();
        innerClazS.run();

        InnerClaT innerClaT = new InnerClassStudy().new InnerClaT();
        innerClaT.run();

        //4.利用反射
        try {
            Class clazz = InnerClassStudy.class; //外部类Class
            Class claIn = InnerClaT.class; //内部类Class
            Constructor con = claIn.getDeclaredConstructor(clazz); //获取内部类的构造器
            con.setAccessible(true); //将构造器设为可用
            InnerClaT innerClaT1 = (InnerClaT) con.newInstance(innerClassStudy);
            innerClaT1.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
