package com.ranx.chowder.study.designPatterns.visitor_muldispatch;

/**
 * 角色接口
 * @author ranx
 * @create 2019-05-10 17:16
 **/
public interface Role {

    public void accept(AbsActor actor);
}
