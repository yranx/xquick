package com.ranx.chowder.study.designPatterns.factory_multi;


import com.ranx.chowder.study.designPatterns.factory_human.BlackHuman;
import com.ranx.chowder.study.designPatterns.factory_human.Human;
import com.ranx.chowder.study.designPatterns.factory_human.YellowHuman;

/**
 * @author ranx
 * @create 2018-11-21 17:27
 **/
public class YellowHumanFactory extends AbstractHumanFactory {

    @Override
    public Human createHuman() {
        return new YellowHuman();
    }
}
