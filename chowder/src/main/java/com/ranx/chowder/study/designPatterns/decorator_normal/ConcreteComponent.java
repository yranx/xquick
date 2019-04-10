package com.ranx.chowder.study.designPatterns.decorator_normal;

/**
 * 具体插件
 * @author ranx
 * @create 2019-04-10 16:55
 **/
public class ConcreteComponent extends Component {
    @Override
    public void operate() {
        System.out.println("do Something");
    }
}
