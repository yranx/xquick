package com.ranx.chowder.study.designPatterns.factory_multi;


import com.ranx.chowder.study.designPatterns.factory_human.BlackHuman;
import com.ranx.chowder.study.designPatterns.factory_human.Human;

/**
 * @author ranx
 * @create 2018-11-21 17:27
 **/
public class BlackHumanFactory extends AbstractHumanFactory {

    @Override
    public Human createHuman() {
        return new BlackHuman();
    }
}
