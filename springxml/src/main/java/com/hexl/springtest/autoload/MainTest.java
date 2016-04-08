package com.hexl.springtest.autoload;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void TestExecuteAction(){
		UserAction userAction=(UserAction)ac.getBean("userAction");
		userAction.execute();
	}
}
