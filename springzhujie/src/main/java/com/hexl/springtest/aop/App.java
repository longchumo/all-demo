package com.hexl.springtest.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void TestExecuteAction(){
		
		IOrderDao userDao=(IOrderDao)ac.getBean("orderDao");
		System.out.println(userDao.getClass());
		userDao.save();
	}
}
