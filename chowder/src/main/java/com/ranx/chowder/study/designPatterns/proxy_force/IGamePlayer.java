package com.ranx.chowder.study.designPatterns.proxy_force;

/**
 * @Description: 强制代理的游戏者接口
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
	//每个人都可以找一下自己的代理
	public IGamePlayer getProxy();
}
