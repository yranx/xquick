package com.ranx.chowder.study.designPatterns.proxy_game1;

import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

/**
 * @Description: 场景类
 * @author ranx
 * @date 2019-3-21-下午6:10:02

 */
public class Client {
	
	public static void main(String[] args) {
		IGamePlayer player = new GamePlayer("张三");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("开始时间：" + sdf.format(System.currentTimeMillis()));
		player.login("ranx", "password");
		player.killBoss();
		player.upgreade();
		System.out.println("结束时间：" + sdf.format(System.currentTimeMillis()));
	}

}
