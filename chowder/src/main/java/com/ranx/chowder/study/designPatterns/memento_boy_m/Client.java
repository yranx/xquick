package com.ranx.chowder.study.designPatterns.memento_boy_m;

/**
 * @author ranx
 * @create 2019-04-28 14:43
 **/
public class Client {
    public static void main(String[] args) {
        Boy boy = new Boy();
        //声明备忘录管理者
        Caretaker caretaker = new Caretaker();
        boy.setState("心情很棒！");
        System.out.println("男孩现在的状态：" + boy.getState());
        //记录下当前状态
//        Memento mem = boy.createMemento();
        caretaker.setMemento(boy.createMemento());
        boy.changeState();
        System.out.println("男孩追女孩后的状态：" + boy.getState());
        //追女孩失败，恢复原状
//        boy.restoreMemento(mem);
        boy.restoreMemento(caretaker.getMemento());
        System.out.println("男孩恢复后的状态：" + boy.getState());
    }


}
