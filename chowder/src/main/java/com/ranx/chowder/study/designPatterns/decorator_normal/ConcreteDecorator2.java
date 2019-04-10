package com.ranx.chowder.study.designPatterns.decorator_normal;

/**
 * 具体的装饰类
 * @author ranx
 * @create 2019-04-10 17:36
 **/
public class ConcreteDecorator2 extends Decorator{
    //定义被修饰者
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void method2() {
        System.out.println("method2 修饰");
    }

    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
