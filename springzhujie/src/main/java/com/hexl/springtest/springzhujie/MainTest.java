package com.hexl.springtest.springzhujie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class MainTest {
	
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void TestExecuteAction(){
		UserAction userAction=(UserAction)ac.getBean("userAction");
		userAction.execute();
	}
}
