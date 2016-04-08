package com.hexl.java.test.thread.create;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startExtendThread();
		
		startInterfaceThread();
	}
	
	public static void startExtendThread(){
		new ExThread().start();
		new ExThread().start();
		new ExThread().start();
		new ExThread().start();
		new ExThread().start();
	}
	
	public static void startInterfaceThread(){
		Runnable runnable=new ItfThread();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
	}

}
