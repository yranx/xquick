package com.ranx.chowder.designPatterns.proxy_dynamic;

/**
 * @Description: 游戏者接口
 * @author ranx
 * @date 2019-3-21-下午5:58:22

 */
public interface IGamePlayer {
	//登录
	public void login(String user, String password);
	//打怪
	public void killBoss();
	//升级
	public void upgreade();
}
