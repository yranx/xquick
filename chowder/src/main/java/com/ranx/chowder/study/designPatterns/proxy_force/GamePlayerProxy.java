package com.ranx.chowder.study.designPatterns.proxy_force;

/**
 * @Description: 强制代理的代练者
 * @author ranx
 * @date 2019-3-22-下午2:07:21

 */
public class GamePlayerProxy implements IGamePlayer {
	private IGamePlayer gamePlayer = null;
	//通过构造函数传递要对谁进行代练
	public GamePlayerProxy(IGamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}
	
	@Override
	public void login(String user, String password) {
		this.gamePlayer.login(user, password);
	}
	
	@Override
	public void killBoss() {
		this.gamePlayer.killBoss();
	}
	
	@Override
	public void upgreade() {
		this.gamePlayer.upgreade();
	}

	//代理的代理暂时没有还没有，就是自己

	@Override
	public IGamePlayer getProxy() {
		return this;
	}
}
