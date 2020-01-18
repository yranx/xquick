package com.ranx.chowder.juc.lockpag;

/**
 * @Description: 卖票
 * @author ranx
 * 2019-8-19上午11:22:39
 */
public class LockMain {
	public static void main(String[] args) {
//		ticketNoLock();
		ticketLock();
	}
	
	public static void ticketNoLock() {
		TicketNoLock tnl = new TicketNoLock();
		new Thread(tnl).start();
		new Thread(tnl).start();
		new Thread(tnl).start();
		System.out.println("over");
	}
	
	public static void ticketLock() {
		TicketLock tnl = new TicketLock();
		new Thread(tnl).start();
		new Thread(tnl).start();
		new Thread(tnl).start();
		System.out.println("over");
	}
}
