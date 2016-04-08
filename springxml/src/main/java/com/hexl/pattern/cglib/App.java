package com.hexl.pattern.cglib;


/*
 * 测试静态代理与动态代理
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///目标对象
		UserDaoB target=new UserDaoB();
		//代理对象
		UserDaoB proxy=(UserDaoB)new CglibProxyFactory(target).getProxyInstance();
		//动态代理
		proxy.save();
	}

}
