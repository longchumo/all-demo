package com.hexl.java.test.thread.create;

/*
 * 线程创建方式二：
 * 1、自定义类实现runnable接口；
 * 2、实现run方法
 * 3、创建Runnable实现类的对象；
 * 4、创建Thread对象，把实现类对象作为参数传递；
 * 5、调用Thread的start方法，启动线程
 */
public class ItfThread implements Runnable {

	private int tickets=100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(tickets>0){
			System.out.println(Thread.currentThread().getName()+"卖出第"+tickets--+"张火车票");
		}
	}

	

}
