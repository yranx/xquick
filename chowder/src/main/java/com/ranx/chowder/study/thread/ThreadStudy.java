package com.ranx.chowder.study.thread;

/**
 * @author ranx
 * @create 2018-09-20 22:37
 **/
public class ThreadStudy {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };

        t.run();
        System.out.println("ping");
        System.out.println("5" + 2);
    }

    static void pong() {
        System.out.print("pong");
    }
}
