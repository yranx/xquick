package com.ranx.chowder.designPatterns.flyweight_thread_unsafe;

/**
 * @author ranx
 * @create 2019-06-06 19:27
 **/
public class MultiThread extends Thread {
    private SignInfo signInfo;

    public MultiThread(SignInfo signInfo) {
        this.signInfo = signInfo;
    }

    public void run() {
        if (!signInfo.getId().equals(signInfo.getLocation())) {
            System.out.println("编号：" +  signInfo.getId());
            System.out.println("考试地址：" + signInfo.getLocation());
            System.out.println("线程非安全");
        }
    }
}
