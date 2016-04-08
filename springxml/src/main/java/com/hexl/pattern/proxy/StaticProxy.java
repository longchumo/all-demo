package com.hexl.pattern.proxy;

//静态代理
public class StaticProxy implements IUserDaoA{
	private IUserDaoA target;
	public StaticProxy(IUserDaoA iUserDaoA){
		target=iUserDaoA;
	}
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("开始事物");
		target.save();
		System.out.println("结束事物");
	}
	
}
