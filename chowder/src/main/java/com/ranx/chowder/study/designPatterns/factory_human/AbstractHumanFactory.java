package com.ranx.chowder.study.designPatterns.factory_human;

/**
 * 抽象人类创建工厂，生产管理者，只需知道生成什么，不需事物的具体信息
 * @author ranx
 * @create 2018-11-21 17:23
 **/
public abstract class AbstractHumanFactory {
    /*
    采用泛型对该方法的输入参数产生两层限制：必须是Class类型，必须是Human的实现类
     */
    public abstract <T extends Human> T createHuman(Class<T> c);
}
