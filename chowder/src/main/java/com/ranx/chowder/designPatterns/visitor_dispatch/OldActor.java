package com.ranx.chowder.designPatterns.visitor_dispatch;

/**
 * @author ranx
 * @create 2019-05-10 17:27
 **/
public class OldActor extends AbsActor {
    @Override
    public void act(KungFuRole role) {
        System.out.println("年龄大了，不能演功夫角色");
    }
}
