package com.ranx.chowder.jconcurrencypte.j16jmm;

/**
 * @author ranx
 * @create 2019-06-14 14:10
 * 程序中没有包含足够的同步，可能产生奇怪的结果（Don't do it）
 **/
public class PossibleReordering {
    static int x=0, y=0;
    static int a=0, b=0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        });

        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        });

        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("("+ x + "," + y + ")");
    }

}
