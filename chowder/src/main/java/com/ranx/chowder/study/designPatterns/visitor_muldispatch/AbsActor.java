package com.ranx.chowder.study.designPatterns.visitor_muldispatch;

/**
 * 抽象演员
 * @author ranx
 * @create 2019-05-10 17:21
 **/
public abstract class AbsActor {
    public void act(Role role) {
        System.out.println("演员可以扮演任何角色");
    }

    public void act(KungFuRole role) {
        System.out.println("演员都可以演功夫角色");
    }
}
