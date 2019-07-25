package com.ranx.chowder.designPatterns.visitor_muldispatch;

/**
 *
 * @author ranx
 * @create 2019-05-10 17:34
 **/
public class Client {
    public static void main(String[] args) {
        AbsActor actor = new OldActor();
        Role role = new KungFuRole();

        role.accept(actor);
        new KungFuRole().accept(actor);
    }
}

/**
 年龄大了，不能演功夫角色
 年龄大了，不能演功夫角色
 */
