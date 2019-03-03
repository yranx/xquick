package com.ranx.chowder.study.designPatterns.factory_normal;

/**
 * 抽象工厂类
 * 负责定义产品对象的产生
 * @author ranx
 * @create 2019-02-15 16:09
 **/
public abstract class AbstractCreatorFactory {
    /*
    创建一个产品对象，其输入的参数类型可以自行设置
    通常为String、Enum、Class或者为空
     */
    public abstract <T extends Product> T createProduct(Class<T> c);
}
