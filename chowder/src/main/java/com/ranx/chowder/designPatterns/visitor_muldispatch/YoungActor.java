package com.ranx.chowder.designPatterns.visitor_muldispatch;


/**
 * @author ranx
 * @create 2019-05-10 17:27
 **/
public class YoungActor extends AbsActor {
    @Override
    public void act(KungFuRole role) {
        System.out.println("最喜欢演功夫角色");
    }
}
