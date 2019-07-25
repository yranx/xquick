package com.ranx.chowder.designPatterns.memento_boy;

/**
 * @author ranx
 * @create 2019-04-28 14:43
 **/
public class Client {
    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.setState("心情很棒！");
        System.out.println("男孩现在的状态：" + boy.getState());
        //记录下当前状态
        Boy backup = new Boy();
        backup.setState(boy.getState());
        boy.changeState();
        System.out.println("男孩追女孩后的状态：" + boy.getState());
        //追女孩失败，恢复原状
        boy.setState(backup.getState());
        System.out.println("男孩恢复后的状态：" + boy.getState());
    }


}
