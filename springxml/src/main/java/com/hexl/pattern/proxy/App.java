package com.hexl.pattern.proxy;
/*
 * 测试静态代理与动态代理
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///目标对象
		IUserDaoA userDao=new UserDaoA();
		//代理对象
		StaticProxy proxy=new StaticProxy(userDao);
		proxy.save();
		//动态代理
		IUserDaoA dproxy=(IUserDaoA) new DynamicProxyFactory(userDao).getProxyInstance();
		dproxy.save();
	}

}
