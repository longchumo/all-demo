package com.hexl.aop;



public class OrderDao implements IOrderDao{

	public void save() {
		System.out.println("-----核心业务：保存-----");
	}
}
