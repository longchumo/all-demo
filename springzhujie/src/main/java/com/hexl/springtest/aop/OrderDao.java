package com.hexl.springtest.aop;

import org.springframework.stereotype.Component;

@Component
public class OrderDao implements IOrderDao{

	public void save() {
		System.out.println("-----核心业务：保存-----");
	}
}
