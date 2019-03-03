package com.ranx.chowder.study.designPatterns.abstract_factory_human;

public interface HumanFactory {

    public Human createYellowHuman();

    public Human createWhiteHuman();

    public Human createBlackHuman();
}
