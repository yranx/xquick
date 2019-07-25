package com.ranx.chowder.designPatterns.proxy_game1;

/**
 * @Description: 游戏者
 * @author ranx
 * @date 2019-3-21-下午6:02:03

 */
public class GamePlayer implements IGamePlayer {

	private String name="";
	
	
	//通过构造函数传递名称
	public GamePlayer(String name) {
		super();
		this.name = name;
	}

	@Override
	public void login(String user, String password) {
		System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");

	}

	@Override
	public void killBoss() {
		System.out.println(this.name + "在打怪！");

	}

	@Override
	public void upgreade() {
		System.out.println(this.name + "又升了一级！");

	}

}
