package com.ranx.chowder.study.designPatterns.proxy_game2;

/**
 * @Description: 代练者
 * @author ranx
 * @date 2019-3-22-下午2:07:21

 */
public class GamePlayerProxy implements IGamePlayer{
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


}
