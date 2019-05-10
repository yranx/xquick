package com.ranx.chowder.study.designPatterns.proxy_force;

/**
 * @Description: 强制代理的真实角色
 * @author ranx
 * @date 2019-3-21-下午6:02:03

 */
public class GamePlayer implements IGamePlayer {

	private String name="";

	private IGamePlayer proxy = null;
	//通过构造函数传递名称
	public GamePlayer(String name) {
		this.name = name;
	}

	//找到自己的代理
	public IGamePlayer getProxy() {
	    //这里有点问题啊
		//Todo
//	    this.proxy = new GamePlayerProxy(this.name);
		this.proxy = new GamePlayerProxy(proxy);
	    return this.proxy;
    }

	@Override
	public void login(String user, String password) {
        if (this.isProxy()) {
            System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
        }  else {
            System.out.println("请使用指定的代理访问");
        }
	}

	@Override
	public void killBoss() {
	    if (this.isProxy()) {
            System.out.println(this.name + "在打怪！");
        } else {
            System.out.println("请使用指定的代理访问");
        }
	}

	@Override
	public void upgreade() {
        if (this.isProxy()) {
            System.out.println(this.name + "又升了一级！");
        }  else {
            System.out.println("请使用指定的代理访问");
        }
	}

	//检验是否是代理访问
    private boolean isProxy() {
	    if (this.proxy == null) {
	        return false;
        } else {
	        return true;
        }
    }

}
