package com.ranx.chowder.study.designPatterns.abstract_factory_human;

/**
 * @author ranx
 * @create 2019-02-16 11:57
 **/
public class MaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
//        return new MaleWhiteHuman();
        return null;
    }

    @Override
    public Human createBlackHuman() {
//        return new MaleBlackHuman();
        return null;
    }
}
