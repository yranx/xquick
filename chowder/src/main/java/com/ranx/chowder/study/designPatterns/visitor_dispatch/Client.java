package com.ranx.chowder.study.designPatterns.visitor_dispatch;

/**
 * 这个结果是有问题的，暴露我的问题啊
 * @author ranx
 * @create 2019-05-10 17:34
 **/
public class Client {
    public static void main(String[] args) {
        AbsActor actor = new OldActor();
        Role role = new KungFuRole();
//        KungFuRole role = new KungFuRole();

        actor.act(role);
        actor.act(new KungFuRole());
    }
}

/**
 演员可以扮演任何角色
 年龄大了，不能演功夫角色
 */
