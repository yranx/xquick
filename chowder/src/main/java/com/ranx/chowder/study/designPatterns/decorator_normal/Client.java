package com.ranx.chowder.study.designPatterns.decorator_normal;

/**
 * @author ranx
 * @create 2019-04-10 18:09
 **/
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
        //修饰后运行
        component.operate();
    }
}
