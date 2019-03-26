package com.ranx.chowder.study.designPatterns.proxy_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

/**
 * @Description: 动态代理场景类
 * @author ranx
 * @date 2019-3-21-下午6:10:02

 */
public class Client {
	
	public static void main(String[] args) {
		IGamePlayer player = new GamePlayer("张三");

		//定义一个handler
        InvocationHandler handler = new GamePlayIH(player);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("开始时间：" + sdf.format(System.currentTimeMillis()));

		//获取类的class loader
        ClassLoader cl = player.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
        proxy.login("ranx", "password");
        proxy.killBoss();
        proxy.upgreade();
		System.out.println("结束时间：" + sdf.format(System.currentTimeMillis()));

	}

}
