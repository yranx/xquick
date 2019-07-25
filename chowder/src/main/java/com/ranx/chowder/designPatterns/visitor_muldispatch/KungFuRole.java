package com.ranx.chowder.designPatterns.visitor_muldispatch;

/**
 * @author ranx
 * @create 2019-05-10 17:18
 **/
public class KungFuRole implements Role {
    @Override
    public void accept(AbsActor actor) {
        actor.act(this);
    }
}
