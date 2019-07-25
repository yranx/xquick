package com.ranx.chowder;

/**
 * finalize方法复活对象
 * @author ranx
 * @create 2018-09-16 23:27
 **/
public class CanReliveObj {
    public static CanReliveObj obj;

    //当执行GC时，会执行finalize方法，并且只会执行一次
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");

        /*
        当执行GC时，会执行finalize方法，
         */
        obj = this;  //将null的object复活一下，变成可触及性
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
        obj = null;//可复活
        System.out.println("第一次gc");
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj is null");
        } else {
            System.out.println("obj可用");
        }
    }
}
