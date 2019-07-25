package com.ranx.chowder.designPatterns.abstract_factory_human;

public interface HumanFactory {

    public Human createYellowHuman();

    public Human createWhiteHuman();

    public Human createBlackHuman();
}
