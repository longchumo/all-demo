package com.hexl.springtest.springxml;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 1、创建SpringBean的两种方式
 * 2、对象默认单列，通过scope改为多列
 * 3、单列在启动前创建；多列在容器创建后用到对象时候才创建
 * 4、
 *
 */
public class CreateBeanTest 
{
	// 通过工厂类得到IOCrongqi对象
	@Test
	public void testIoc() throws Exception{
		//对象交给IOC
		Resource rs=new ClassPathResource("applicationContext.xml");
		//创建容器对象
		BeanFactory fc=new XmlBeanFactory(rs);
		//得到对象
		User user=(User)fc.getBean("user");
		System.out.println( user);
	}
	
	//直接获得IOC容器对象
	@Test
	public void testAc() throws Exception{
		//得到IOC容器对象
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("容器创建");
		//容器中获取bean
		User user=(User)ac.getBean("user");
		User user2=(User)ac.getBean("user");
		System.out.println( user);
		System.out.println( user2);
		
		Product product=(Product)ac.getBean("product");
		Product product2=(Product)ac.getBean("product");		
		System.out.println( product);
		System.out.println( product2);
		
		//带参数构造器
		User usercs=(User)ac.getBean("user1");
		System.out.println( usercs);
		
		//property赋值
		User userp=(User)ac.getBean("user2");
		System.out.println( userp.getUserName());
		
	}
	
	
}
