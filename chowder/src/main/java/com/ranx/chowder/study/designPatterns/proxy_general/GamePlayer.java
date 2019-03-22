package com.ranx.chowder.study.designPatterns.proxy_general;

/**
 * @Description: 普通代理的游戏者
 * @author ranx
 * @date 2019-3-21-下午6:02:03

 */
public class GamePlayer implements IGamePlayer {

	private String name="";
	
	
	//通过构造函数限制谁能创建对象，并同时传递名称
	public GamePlayer(IGamePlayer gamePlayer, String name) throws Exception {
		if (gamePlayer == null) {
			throw new Exception("不能创建真实角色!");
		} else {
            this.name = name;
        }
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
