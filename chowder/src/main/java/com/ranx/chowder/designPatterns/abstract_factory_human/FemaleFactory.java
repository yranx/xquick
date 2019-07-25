package com.ranx.chowder.designPatterns.abstract_factory_human;

/**
 * @author ranx
 * @create 2019-02-16 11:57
 **/
public class FemaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
//        return new FemaleWhiteHuman();
        return null;
    }

    @Override
    public Human createBlackHuman() {
//        return new FemaleBlackHuman();
        return null;
    }
}
