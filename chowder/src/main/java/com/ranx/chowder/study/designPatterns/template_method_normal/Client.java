package com.ranx.chowder.study.designPatterns.template_method_normal;

/**
 * @author ranx
 * @create 2019-02-18 22:12
 **/
public class Client {
    public static void main(String[] args) {
        AbstractClass clas1 = new ConcreteClass1();
        AbstractClass clas2 = new ConcreteClass2();
        //调用模板方法
        clas1.templateMethod();
        clas2.templateMethod();
    }
}
