package com.ranx.chowder.study.designPatterns.factory_multi;

import com.ranx.chowder.study.designPatterns.factory_human.Human;

/**
 * 多工厂模式的抽象工厂类
 * @author ranx
 * @create 2018-11-21 17:23
 **/
public abstract class AbstractHumanFactory {

    public abstract Human createHuman();
}
