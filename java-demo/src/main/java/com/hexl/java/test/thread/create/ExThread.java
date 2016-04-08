package com.hexl.java.test.thread.create;
/*
 * 线程创建方式一：
 * 1、自定义类继承Thread；
 * 2、实现run方法
 * 3、创建自定义类，执行start方法；
 */
public class ExThread extends Thread {

	private int tickets=50;
	
	public void run(){
		while(tickets>0){
			System.out.println(this.getName()+"卖出第"+(tickets--)+"张火车票");
		}
	}
}
