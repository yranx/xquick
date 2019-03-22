package com.ranx.chowder.study.designPatterns.proxy_general;

import java.text.SimpleDateFormat;

/**
 * 普通代理的场景类
 * @author ranx
 * @create 2019-03-22 17:45
 **/
public class Client {
    public static void main(String[] args) {
        IGamePlayer proxy = new GamePlayerProxy("张三");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间：" + sdf.format(System.currentTimeMillis()));
        proxy.login("ranx", "password");
        proxy.killBoss();
        proxy.upgreade();
        System.out.println("结束时间：" + sdf.format(System.currentTimeMillis()));
    }
}
