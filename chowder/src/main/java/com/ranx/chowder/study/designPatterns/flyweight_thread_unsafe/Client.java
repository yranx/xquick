package com.ranx.chowder.study.designPatterns.flyweight_thread_unsafe;

/**
 * @author ranx
 * @create 2019-05-25 21:31
 **/
public class Client {
    public static void main(String[] args) {
        SignInfoFactory.getSignInfo("科目1");
        SignInfoFactory.getSignInfo("科目2");
        SignInfoFactory.getSignInfo("科目3");
        SignInfoFactory.getSignInfo("科目4");
        //取得对象
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目2");
        //对象池中保留四个对象，启动N多个线程来模拟
        while(true) {
            signInfo.setId("ran");
            signInfo.setLocation("ran");
            (new MultiThread(signInfo)).start();
            signInfo.setId("ha");
            signInfo.setLocation("ha");
            (new MultiThread(signInfo)).start();
        }
    }
}
