package com.ranx.chowder.study.designPatterns.decorator_normal;

/**
 * 抽象装饰者
 * @author ranx
 * @create 2019-04-10 16:57
 **/
public abstract class Decorator extends Component{
    private Component component = null;
    //通过构造函数传递被修饰者
    public Decorator(Component component) {
        this.component = component;
    }

    //委托给被修饰者执行
    @Override
    public void operate() {
        this.component.operate();
    }
}
